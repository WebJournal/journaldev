package com.journaldev.androidadapterviewflipper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterViewFlipperAdapter extends BaseAdapter {

    private ArrayList<AndroidVersion> androidVersions;
    private Context mContext;

    public AdapterViewFlipperAdapter(Context context, ArrayList<AndroidVersion> androidVersions) {
        this.mContext = context;
        this.androidVersions = androidVersions;
    }

    @Override
    public int getCount() {
        return androidVersions.size();
    }

    @Override
    public Object getItem(int position) {
        return androidVersions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.row_view_item, parent, false);
        }

        AndroidVersion version = androidVersions.get(position);

        TextView textView = convertView.findViewById(R.id.textView);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        textView.setText(version.versionName);
        imageView.setImageResource(version.drawableInt);

        return convertView;
    }
}

