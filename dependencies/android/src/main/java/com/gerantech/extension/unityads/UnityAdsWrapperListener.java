package com.gerantech.extension.unityads;

import android.util.Log;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class UnityAdsWrapperListener implements IUnityAdsListener/*, IUnityBannerListener*/ {
	public static final String TAG = "uads";

	public void onUnityInitialize(boolean succeed, String message) {
		send("init", succeed, message);
	}

	}
