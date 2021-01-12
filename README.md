extension-unityads
=============

Simple OpenFL/Haxe extension for Unity Ads.

Currently implements methods to use the android vibrator and access screen
dimensions.

Install via 
`haxelib git extension-unityads https://github.com/manjav/haxe-extension-unityads`

Add to `project.xml`:

```xml
<haxelib name="extension-unityads" if="android" />
```

And import into your project (haxe) with:
  
```Haxe
import com.gerantech.extension.unityads.UnityAds;
```

Exposed methods are currently:
```Haxe
UnityAds.onInit = function(succeed:Bool, message:String):Void {
	trace("onInit => " + succeed, message);
};
```

When even ads are ready, return a placement-id with which you can showAds();
```Haxe
UnityAds.onAdReady = function(placementId:String):Void {
	trace("onAdReady => " + placementId);
	// UnityAds.showAd(placementId);
};
```

Other callbacks
```Haxe
UnityAds.onAdStart = function(placementId:String):Void {
	trace("onAdStart => " + placementId);
};
UnityAds.onAdFinish = function(placementId:String, result:String):Void {
	trace("onAdFinish => " + placementId + " result => " + result);
};
UnityAds.onAdError = function(error:String, message:String):Void {
	trace("onAdError => " + error + " message => " + message);
};

UnityAds.init("3974257", true, true); 
```