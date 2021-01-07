package com.gerantech.extension.unityads;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#elseif (android && openfl)
import lime.system.JNI;
#end

class UnityAds {
	///callbacks haxe
	public static var onInit:Bool->String->Void = null;
	public static var _instance:UnityAds = null;


	public static function init(gameId:String, testMode:Bool = false, debugMode:Bool = false):Void {
		libInit(getInstance(), gameId, testMode, debugMode);
	}
	public static function getInstance():UnityAds {
		if (_instance == null)
			_instance = new UnityAds();
		return _instance;
	}


	// event handlers
	public function new() {}

	@:keep
	public function listen(type:String, arg0:Dynamic, arg1:Dynamic):Void {
		if (type == "init" && onInit != null)
			onInit(arg0, arg1);
	}
}
