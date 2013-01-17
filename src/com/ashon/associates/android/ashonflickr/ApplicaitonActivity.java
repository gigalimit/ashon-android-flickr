package com.ashon.associates.android.ashonflickr;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

abstract class ApplicaitonActivity extends Activity {
	
	private 	FlickrApi	flickrApi;
	protected 	String 		mApiKey;
	protected	String		flickrRes;
	
	static final String	JSON_FEED	= "RAW_JSON_FEED";
	
	/**
	 * @return the mApiKey
	 */
	public String getApiKey() {
		return mApiKey;
	}
	
	/**
	 * @param mApiKey the mApiKey to set
	 */
	public void setApiKey(String mApiKey) {
		this.mApiKey = mApiKey;
	}
	
	
	/**
	 * Gets the fickrApi
	 */
	public FlickrApi getFlickrApi(Context context) {
		if (null == flickrApi) {
			if (null != context){
				String apiKey 	= (String) context.getResources().getString(R.string.api_key);
				this.flickrApi 	= (FlickrApi) FlickrApi.getInstance().init(context, apiKey);
			}
		}
		return flickrApi;
	}
	
	/**
	 * 
	 */
	public boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager;
	    connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return (boolean)(activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting());
	}
}
