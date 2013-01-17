package com.ashon.associates.android.ashonflickr;

import android.os.Bundle;
import android.view.Menu;

public class GalleryActivity extends ApplicaitonActivity {
	final static int LISTVIEW_LOADER_ID	= 200;
	String	pixFeed					 	= "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		// Launch the view
		prepareView();
		// Get the Incoming feed
//		Intent	inIntent	= getIntent();
//		String	rawFeed		= inIntent.getStringExtra(JSON_FEED);
//		LoaderManager loaderManager	= getLoaderManager();
//		loaderManager.initLoader(LISTVIEW_LOADER_ID, savedInstanceState, null);
	}

	/**
	 * Prepares all the is need for the view
	 */
	private void prepareView() {
		// Check if we have connection otherwise show nothing else
		if (isNetworkAvailable()){
			// Initialize the FlickrObj
			FlickrApi flickrApi	= getFlickrApi(this);
			
			// Get feed of most recent pictures...
			if (pixFeed.equals("")) {
				pixFeed	= flickrApi.getTopImagesFeed();
			}
			System.out.println(pixFeed);
		} else {
			// Network is not available let's notify use and 
			// show empty screen!
		}
		
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gallery, menu);
		return true;
	}

}
