package com.gerantech.extension.unityads;

import android.util.Log;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class UnityAdsWrapperListener implements IUnityAdsListener/*, IUnityBannerListener*/ {
	public static final String TAG = "uads";

	public void onUnityInitialize(boolean succeed, String message) {
		send("init", succeed, message);
	}

	@Override
	public void onUnityAdsReady(String placementId) {
		send("ready", placementId, "");
	}


	private void send(String type, Object arg0, Object arg1) {
		Log.w(TAG, arg0 + " " + arg1);
		UnityAdsWrapper.callbackObject.call3("listen", type, arg0, arg1);
	}
	}
