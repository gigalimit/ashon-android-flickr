package com.ashon.associates.android.ashonflickr;

import java.util.ArrayList;

import com.ashon.associates.android.ashonflickr.FlickrApi.FlickrImage;

import android.os.AsyncTask;

public class ImagesDownloaderTask extends AsyncTask<String, Void, ArrayList<FlickrImage>> 
{
	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPreExecute()
	 */
	int count	= 0;
	@Override
	protected void onPreExecute() {
		
		super.onPreExecute();
	}
	@Override
	protected ArrayList<FlickrImage> doInBackground(String... params) {
		if (params.length > 0) {
			for(int i = 0; i < params.length; i++) {
				System.out.println("Param:=========\n"+params[i]);
				System.out.println(count++);
//				FlickrApi flickrApiObj	= new ;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */
	@Override
	protected void onPostExecute( ArrayList<FlickrImage> result) {
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
