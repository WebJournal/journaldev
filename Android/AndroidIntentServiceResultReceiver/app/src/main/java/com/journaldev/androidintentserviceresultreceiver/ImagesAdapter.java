package com.journaldev.androidintentserviceresultreceiver;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImagesAdapter extends ArrayAdapter<Bitmap> {

    private Context mContext;
    private List<Bitmap> bitmapList;

    public ImagesAdapter(@NonNull Context context, ArrayList<Bitmap> list) {
        super(context, R.layout.listview_item_row, list);
        mContext = context;
        bitmapList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_item_row, parent, false);

        Bitmap bitmap = bitmapList.get(position);

        ImageView image = convertView.findViewById(R.id.imageView);
        image.setImageBitmap(bitmap);

        return convertView;
    }


    @Override
    public int getCount() {
        return bitmapList.size();
    }
}
