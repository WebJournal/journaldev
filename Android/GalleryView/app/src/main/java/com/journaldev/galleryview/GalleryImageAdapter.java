package com.journaldev.galleryview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by anupamchugh on 24/10/15.
 */
public class GalleryImageAdapter extends BaseAdapter
{
    private Context mContext;



    public GalleryImageAdapter(Context context)
    {
        mContext = context;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }


    // Override this method according to your need
    public View getView(int index, View view, ViewGroup viewGroup)
    {
        // TODO Auto-generated method stub
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[index]);
        i.setLayoutParams(new Gallery.LayoutParams(200, 200));

        i.setScaleType(ImageView.ScaleType.FIT_XY);


        return i;
    }

   public Integer[] mImageIds = {
            R.drawable.alarm,
            R.drawable.explore,
            R.drawable.language,
            R.drawable.lock,
            R.drawable.print,
            R.drawable.rotation_3d,
            R.drawable.spellcheck,
            R.drawable.redeem
    };

}

