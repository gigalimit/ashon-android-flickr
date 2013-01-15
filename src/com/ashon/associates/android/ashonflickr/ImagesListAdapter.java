package com.ashon.associates.android.ashonflickr;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ImagesListAdapter extends ArrayAdapter<String> {
	

	protected final Context context;
	protected final String []list;
	
	public ImagesListAdapter(Context context, int textViewResourceId,
			String[] varList) {
		super(context, textViewResourceId, varList);
		this.context	= context;
		this.list		= varList;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return super.getView(position, convertView, parent);
		
	}

}
