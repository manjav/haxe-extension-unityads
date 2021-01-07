package com.gerantech.extension.unityads;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#elseif (android && openfl)
import lime.system.JNI;
#end

class UnityAds {
	public static var _instance:UnityAds = null;

	public static function getInstance():UnityAds {
		if (_instance == null)
			_instance = new UnityAds();
		return _instance;
	}

}
