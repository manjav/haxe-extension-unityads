package com.gerantech.extension.unityads;

import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.PlayerMetaData;
import com.unity3d.services.core.webview.WebView;

import org.haxe.extension.Extension;
import org.haxe.lime.HaxeObject;

public class UnityAdsWrapper extends Extension {

	private static String gameId;
	private static boolean initialized;
	public static HaxeObject callbackObject;
	private static UnityAdsWrapperListener listener;

	private static int ordinal = 1;

	//init UnityAds with the provided gameId and set up the haxe callback. set up test mode if is specified
	public static void init(HaxeObject cbo, String id, boolean testMode, boolean debugMode) {

		if (initialized) {
			listener.onUnityInitialize(false, "UnityAds already initialized.");
			return;
		}
		callbackObject = cbo;
		gameId = id;

		listener = new UnityAdsWrapperListener();
		UnityAds.addListener(listener);
		UnityAds.setDebugMode(debugMode);
        mainActivity.runOnUiThread (new Thread(new Runnable() {  
            public void run() {
				WebView.setWebContentsDebuggingEnabled(true);
             }
        }));


		MediationMetaData mediationMetaData = new MediationMetaData(mainContext);
		mediationMetaData.setName("mediationPartner");
		mediationMetaData.setVersion("v12345");
		mediationMetaData.commit();

		UnityAds.initialize(mainContext, gameId, testMode, new IUnityAdsInitializationListener() {
			@Override
			public void onInitializationComplete() {
				listener.onUnityInitialize(true, "initialized.");
				initialized = true;
			}

			@Override
			public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
				listener.onUnityInitialize(false, message);
			}
		});
	}

	public static void showAd(String placementId) {
		PlayerMetaData playerMetaData = new PlayerMetaData(mainContext);
		playerMetaData.setServerId("rikshot");
		playerMetaData.commit();

		MediationMetaData ordinalMetaData = new MediationMetaData(mainContext);
		ordinalMetaData.setOrdinal(ordinal++);
		ordinalMetaData.commit();

		UnityAds.show(mainActivity, placementId);
	}

	/*public static void showBanner(String placementId) {
		if (bannerShowing) {
			UnityBanners.destroy();
		} else {
			UnityBanners.setBannerPosition(BannerPosition.);
			UnityBanners.setBannerListener(UnityAdsFragment.this);
			UnityBanners.loadBanner(mainActivity, placementId);
		}
	}*/

	/*public static boolean canShowAd() {
		if (UnityAds.canShow() && UnityAds.canShowAds()) {
			return true;
		} else {
			return false;
		}
	}*/
}
