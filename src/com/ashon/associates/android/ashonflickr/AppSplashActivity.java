package com.ashon.associates.android.ashonflickr;

import java.util.Timer;
import java.util.TimerTask;


import android.os.Bundle;
import android.content.Intent;
import android.content.res.Resources;

public class AppSplashActivity extends ApplicaitonActivity {
	protected Timer _timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_splash);
		
		delaySplash();
	}

	private void delaySplash() {
		// Create the flickrInstance
		getFlickrApi(this);
		
		Resources	res	= getResources();
		int countDown	= 1000 * res.getInteger(R.integer.splash_delay);
		_timer = new Timer();

		_timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// lunch off gallery activity
				launchGallery();
				// Stop timer
				_timer.cancel();
				_timer.purge();
				finish();
				
			}
		}, countDown);
		
	}

	private void launchGallery() {
		// Launch default page
		Intent	galleryIntent	= new Intent(this, GalleryActivity.class);
		startActivity(galleryIntent);
		
	}

}
