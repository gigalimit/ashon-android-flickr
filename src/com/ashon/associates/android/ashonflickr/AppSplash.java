package com.ashon.associates.android.ashonflickr;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.ashon.associates.android.ashonflickr.FlickrApi.FlickrImage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;

public class AppSplash extends ApplicaitonActivity {
	protected Timer _timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_splash);
		// Kill the screen
		doSplash();
	}

	private void doSplash() {
		// Initialize AsyncTask
		AsyncTask<String, Void, ArrayList<FlickrImage>> asyncTask	= new ImagesDownloaderTask();
		// Get Flickr Api Obj
		FlickrApi flickrApiObj	= this.getFlickrApi();
		// Fetch recent images
		String jsonFeed	= flickrApiObj.getTopImages();
		
		// lunch off gallery activity
		launchGallery(jsonFeed);
/*		Resources	res	= getResources();
		int countDown	= 1000 * res.getInteger(R.integer.splash_delay);
		_timer = new Timer();

		_timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				launchCalc();
				// Stop timer
				_timer.cancel();
				_timer.purge();
				finish();
				
			}
		}, countDown);
*/		
	}

	private void launchGallery(String feed) {
		// Launch default page
		Intent	galleryIntent	= new Intent(this, GalleryActivity.class);
		galleryIntent.putExtra(JSON_FEED, feed);
		startActivity(galleryIntent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_app_splash, menu);
		return true;
	}

}
