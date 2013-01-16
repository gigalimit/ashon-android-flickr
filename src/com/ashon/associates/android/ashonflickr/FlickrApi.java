package com.ashon.associates.android.ashonflickr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.json.JSONObject;

import android.content.Context;
import android.widget.Toast;

public class FlickrApi 
{
	/**
	 * Image class to hold each image data
	 * 
	 * @author yinka
	 *
	 */
	public class FlickrImage {
		protected	String	imageUrlThmb	= "";
		protected	String	imageUrl		= "";
		protected	String	imageDesc		= "No description";
		protected	String	imageTitle		= "Unknown Title";
		protected	int		imageWidth;
		/**
		 * @return the imageWidth
		 */
		public int getImageWidth() {
			return imageWidth;
		}
		/**
		 * @param imageWidth the imageWidth to set
		 */
		public void setImageWidth(int imageWidth) {
			this.imageWidth = imageWidth;
		}
		/**
		 * @return the imageHeight
		 */
		public int getImageHeight() {
			return imageHeight;
		}
		/**
		 * @param imageHeight the imageHeight to set
		 */
		public void setImageHeight(int imageHeight) {
			this.imageHeight = imageHeight;
		}
		protected	int		imageHeight;
		
		/**
		 * @return the imageUrlThmb
		 */
		public String getImageUrlThmb() {
			return imageUrlThmb;
		}
		/**
		 * @param imageUrlThmb the Image thumbnail URL to set
		 */
		public void setImageUrlThmb(String imageUrlThmb) {
			this.imageUrlThmb = imageUrlThmb;
		}
		/**
		 * @return the imageUrl
		 */
		public String getImageUrl() {
			return imageUrl;
		}
		/**
		 * @param imageUrl the image URL to set
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		/**
		 * @return the imageDesc
		 */
		public String getImageDesc() {
			return imageDesc;
		}
		/**
		 * @param imageDesc the image description to set
		 */
		public void setImageDesc(String imageDesc) {
			this.imageDesc = imageDesc;
		}
		/**
		 * @return the imageTitle
		 */
		public String getImageTitle() {
			return imageTitle;
		}
		/**
		 * @param imageTitle the imageTitle to set
		 */
		public void setImageTitle(String imageTitle) {
			this.imageTitle = imageTitle;
		}
	}
	
	protected	Context			context;
	protected 	String 			mApiKey	= "";
	protected	HttpPost		mhttpPost;
	protected	HttpResponse	mhttpResponse;
	// The array of our image class
	protected	ArrayList<FlickrImage> imagesArray	= new ArrayList<FlickrApi.FlickrImage>(1);
	
	final static String FLICKR_SERVICE_ENDPOINT	= "http://api.flickr.com/services/rest";
	final static String FLICKR_RECENT_IMAGES		= "flickr.photos.getRecent";
	final static String FLICKR_SEARCH_IMAGES		= "flickr.photos.search";
	/**
	 * sizes canblog="1" canprint="1" candownload="1">
  <size label="Square" width="75" height="75" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_s.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/sq/" media="photo" />
  <size label="Large Square" width="150" height="150" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_q.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/q/" media="photo" />
  <size label="Thumbnail" width="100" height="75" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_t.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/t/" media="photo" />
  <size label="Small" width="240" height="180" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_m.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/s/" media="photo" />
  <size label="Small 320" width="320" height="240" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_n.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/n/" media="photo" />
  <size label="Medium" width="500" height="375" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/m/" media="photo" />
  <size label="Medium 640" width="640" height="480" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_z.jpg?zz=1" url="http://www.flickr.com/photos/stewart/567229075/sizes/z/" media="photo" />
  <size label="Medium 800" width="800" height="600" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_c.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/c/" media="photo" />
  <size label="Large" width="1024" height="768" source="http://farm2.staticflickr.com/1103/567229075_2cf8456f01_b.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/l/" media="photo" />
  <size label="Original" width="2400" height="1800" source="http://farm2.staticflickr.com/1103/567229075_6dc09dc6da_o.jpg" url="http://www.flickr.com/photos/stewart/567229075/sizes/o/" media="photo" />
</sizes>
	 */
	
	/**
	 * Constructor type two
	 * @param String API Key
	 * @throws Exception on empty API Key
	 */
	public FlickrApi(Context context, String apiKey) {
		// Store the context
		this.setContext(context);
		// Store the API key
		if (!apiKey.equals("")) {
			setApiKey(apiKey);
		} else {
			throw new ExceptionInInitializerError("Empty API Key provided!");
		}
	}
	
	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	
	/**
	 * @return the ApiKey
	 */
	public String getApiKey() {
		return mApiKey;
	}

	/**
	 * @param mApiKey the ApiKey to set
	 */
	public void setApiKey(String apiKey) {
		this.mApiKey = apiKey;
	}


	
	protected boolean setupApi()
	{
		return true;
	}
	
	public JSONObject names() {
		JSONObject jsonObj = new JSONObject();
		
		return jsonObj;
	}
	
	/**
	 * This runs a HTTP post operation. A proxy for calling doPost without params
	 *  
	 * @param url
	 * @return String Result of operation
	 */
	public String doPost(String url)
	{
		ArrayList<NameValuePair> emptyName	= new ArrayList<NameValuePair>(1);
		
		return doPost(url, emptyName);
	}

	/**
	 * This runs a HTTP post operation
	 *  
	 * @param url
	 * @param nameValuePairs
	 * @return String Result of operation
	 */
	public String doPost(String url, ArrayList<NameValuePair> nameValuePairs)
	{
		HttpClient		httpClient	= new DefaultHttpClient();
		StringBuilder	strBuilder	= new StringBuilder();
		BufferedReader	bReader;
		System.out.println("URL: "+url);
		System.out.println("Params: "+nameValuePairs.toString());
		// Add the name pairs
		try {
			mhttpPost		= new HttpPost(url);
			mhttpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			mhttpResponse	= httpClient.execute(mhttpPost);
			bReader			= new BufferedReader(
					new InputStreamReader(mhttpResponse.getEntity().getContent())
			);
			String line;
			System.out.println("Buffer@: "+bReader.toString());
			while ((line = bReader.readLine()) != null) {
				System.out.println(line);
				strBuilder.append(line);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			if (this.context != null) {
				Toast.makeText(
					this.context,
					"Failed to access '"+url+"'. Please check your connection",
					Toast.LENGTH_LONG
				).show();
			}
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return strBuilder.toString();
	}
	
	/**
	 * Reads the latest images public available
	 * @return String
	 */
	public String getTopImages()
	{
		ArrayList<NameValuePair> params	= new ArrayList<NameValuePair>(1);
		
		// Add the required params
		params.add(new BasicNameValuePair("api_key", getApiKey()));
		params.add(new BasicNameValuePair("method", FLICKR_RECENT_IMAGES));
		
		// Return result
		return doPost(FLICKR_SERVICE_ENDPOINT, params);
	}
	
	/**
	 * 
	 * @param feed
	 * @return boolead True on successful operation
	 */
	public boolean buildImageListFromFeed(String feed)
	{
		return true;
	}
	

}
