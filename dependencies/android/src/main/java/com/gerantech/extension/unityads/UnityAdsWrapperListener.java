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

	@Override
	public void onUnityAdsStart(String placementId) {
		send("start", placementId, "");
	}

	@Override
	public void onUnityAdsFinish(String placementId, UnityAds.FinishState result) {
		send("finish", placementId, result.toString());
	}

	@Override
	public void onUnityAdsError(UnityAds.UnityAdsError error, String message) {
		send("error", error.toString(), message);
	}

	/*@Override
	public void onUnityBannerLoaded(String placementId, View view) {	}
	@Override
	public void onUnityBannerUnloaded(String placementId) {	}
	@Override
	public void onUnityBannerShow(String placementId) {	}
	@Override
	public void onUnityBannerClick(String placementId) {	}
	@Override
	public void onUnityBannerHide(String placementId) {	}
	@Override
	public void onUnityBannerError(String message) {	}*/

	private void send(String type, Object arg0, Object arg1) {
		Log.w(TAG, arg0 + " " + arg1);
		UnityAdsWrapper.callbackObject.call3("listen", type, arg0, arg1);
	}
}
