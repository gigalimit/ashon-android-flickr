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
	protected	Context			context;
	protected 	String 			mApiKey	= "";
	protected	HttpPost		mhttpPost;
	protected	HttpResponse	mhttpResponse;
	
	final static String FLICKR_SERVICE_ENDPOINT	= "http://api.flickr.com/services/rest";
	final static String FLICKR_RECENT_IMAGES	= "flickr.photos.getRecent";
	final static String FLICKR_SEARCH_IMAGES	= "flickr.photos.search";
	
	/**
	 * Constructor type one
	 */
	public FlickrApi() {
		
	}
	
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
	 * Constructor type two
	 * @param String API Key
	 * @throws Exception on empty API Key
	 */
	public FlickrApi(String apiKey) {
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

}
