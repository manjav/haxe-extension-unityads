package com.gerantech.extension.unityads;

class UnityAds {
	///callbacks haxe
	public static var onInit:Bool->String->Void = null;
	public static var onAdReady:String->Void = null;
	public static var onAdStart:String->Void = null;
	public static var onAdFinish:String->String->Void = null;
	public static var onAdError:String->String->Void = null;

	private static var _instance:UnityAds = null;
	private static var placements:Map<String, Bool> = new Map();

	public static function init(gameId:String, testMode:Bool = false, debugMode:Bool = false):Void {
		libInit(getInstance(), gameId, testMode, debugMode);
	}

	public static function hasAd(placementId:String):Bool {
		return placements.exists(placementId);
	}

	public static function showAd(placementId:String):Void {
		placements.remove(placementId);
		libShowAd(placementId);
	}

	public static function getInstance():UnityAds {
		if (_instance == null)
			_instance = new UnityAds();
		return _instance;
	}

	////java binings
	private static var libInit:UnityAds->String->Bool->Bool->Void =
		#if (android && openfl)
		lime.system.JNI.createStaticMethod("com/gerantech/extension/unityads/UnityAdsWrapper", "init", "(Lorg/haxe/lime/HaxeObject;Ljava/lang/String;ZZ)V");
		#else
		function(o:UnityAds, s:String, b1:Bool, b2:Bool):Void {};
		#end

	private static var libShowAd:String->Void =
		#if (android && openfl)
		lime.system.JNI.createStaticMethod("com/gerantech/extension/unityads/UnityAdsWrapper", "showAd", "(Ljava/lang/String;)V");
		#else
		function(s:String = ""):Void {};
		#end

	// event handlers
	public function new() {}

	@:keep
	public function listen(type:String, arg0:Dynamic, arg1:Dynamic):Void {
		if (type == "init" && onInit != null)
			onInit(arg0, arg1);
		else if (type == "ready" && onAdReady != null) {
			placements.set(arg0, true);
			onAdReady(arg0);
		} else if (type == "start" && onAdStart != null)
			onAdStart(arg0);
		else if (type == "finish" && onAdFinish != null)
			onAdFinish(arg0, arg1);
		else if (type == "error" && onAdError != null)
			onAdError(arg0, arg1);
	}
}
