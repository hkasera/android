package com.duckduckgo.mobile.android.adapters;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.duckduckgo.mobile.android.DDGApplication;
import com.duckduckgo.mobile.android.R;
import com.duckduckgo.mobile.android.download.AsyncImageView;
import com.duckduckgo.mobile.android.util.DDGConstants;
import com.duckduckgo.mobile.android.util.DDGControlVar;

public class SavedResultCursorAdapter extends CursorAdapter {
	Activity parentActivity;
	
    public SavedResultCursorAdapter(Activity parentActivity, Context context, Cursor c) {
        super(context, c);
        this.parentActivity = parentActivity; 
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // when the view will be created for first time,
        // we need to tell the adapters, how each item will look
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.recentsearch_list_layout, parent, false);

        return retView;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // here we are setting our data
        // that means, take the data from the cursor and put it in views

    	final String data = cursor.getString(cursor.getColumnIndex("title"));
    	
        TextView textViewHistory = (TextView) view.findViewById(R.id.recentSearchText);
        textViewHistory.setText(data);
        textViewHistory.setTextSize(DDGControlVar.recentTextSize);
        
        String strUrl = cursor.getString(cursor.getColumnIndex("url"));
        AsyncImageView imageViewHistory = (AsyncImageView) view.findViewById(R.id.recentSearchImage);
        imageViewHistory.setImageResource(R.drawable.icon_history_search);

    }
}