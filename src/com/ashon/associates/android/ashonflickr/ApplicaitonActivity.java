package com.ashon.associates.android.ashonflickr;

import android.app.Activity;

abstract class ApplicaitonActivity extends Activity {
	
	protected 	String 		mApiKey;
	private 	FlickrApi	flickrApi;
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
	 * @return the flickrApi
	 */
	public FlickrApi getFlickrApi() {
		// If empty create a new one
		if (null == flickrApi) {
			flickrApi = new FlickrApi(this.getBaseContext(), getApiKey());
		}
		return flickrApi;
	}
	/**
	 * @param flickrApi the flickrApi to set
	 */
	public void setFlickrApi(FlickrApi flickrApi) {
		this.flickrApi = flickrApi;
	}
	
}
