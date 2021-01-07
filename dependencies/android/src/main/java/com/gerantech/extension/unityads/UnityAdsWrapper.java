package com.gerantech.extension.unityads;

import org.haxe.extension.Extension;
import org.haxe.lime.HaxeObject;

public class UnityAdsWrapper extends Extension {

	private static String gameId;
	private static boolean initialized;
	public static HaxeObject callbackObject;

	private static int ordinal = 1;

	//init UnityAds with the provided gameId and set up the haxe callback. set up test mode if is specified
	public static void init(HaxeObject cbo, String id, boolean testMode, boolean debugMode) {

	}

}
