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

