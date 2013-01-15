package com.ashon.associates.android.ashonflickr;

import android.app.LoaderManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class GalleryActivity extends ApplicaitonActivity {
	final static int LISTVIEW_LOADER_ID	= 200;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		// Get the Incoming feed
		Intent	inIntent	= getIntent();
		String	rawFeed		= inIntent.getStringExtra(JSON_FEED);
//		LoaderManager loaderManager	= getLoaderManager();
//		loaderManager.initLoader(LISTVIEW_LOADER_ID, savedInstanceState, null);
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
