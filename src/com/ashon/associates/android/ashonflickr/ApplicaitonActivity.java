package com.ashon.associates.android.ashonflickr;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

abstract class ApplicaitonActivity extends Activity {
	
	protected 	String 		mApiKey;
	protected	String		flickrRes;
	
	static final String	JSON_FEED	= "RAW_JSON_FEED";
	
	/**
	 * @return the mApiKey
	 */
	public String getApiKey() {
		if (null == mApiKey) {
			mApiKey = "f1e09c524cdda2a4613f8888b678b53b"; // Used temporarily
		}
		return mApiKey;
	}
	
	/**
	 * @param mApiKey the mApiKey to set
	 */
	public void setApiKey(String mApiKey) {
		this.mApiKey = mApiKey;
	}
	
	
	/**
	 * @param flickrApi the flickrApi to set
	 */
	public void setFlickrApi(FlickrApi flickrApi) {
		this.flickrApi = flickrApi;
	}
	
	/**
	 * 
	 */
	public boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager;
	    connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return (boolean)(activeNetworkInfo != null);
	}
}
