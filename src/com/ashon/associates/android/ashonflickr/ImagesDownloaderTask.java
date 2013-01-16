package com.ashon.associates.android.ashonflickr;

import java.util.ArrayList;

import com.ashon.associates.android.ashonflickr.FlickrApi.FlickrImage;

import android.os.AsyncTask;

public class ImagesDownloaderTask extends AsyncTask<String, Void, ArrayList<FlickrImage>> 
{
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPreExecute()
	 */
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}
	@Override
	protected ArrayList<FlickrImage> doInBackground(String... params) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute( ArrayList<FlickrImage> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

	

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onProgressUpdate(Progress[])
	 */
	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

}
