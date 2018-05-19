package com.journaldev.sharedelementtransition;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anupamchugh on 14/04/16.
 */
public class CustomAdapter extends BaseAdapter {
    ArrayList<String[]> arrayList;
    Context c;

    public CustomAdapter(Context c, ArrayList<String[]> list) {
        arrayList = list;
        this.c = c;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row = null;
        LayoutInflater inflater = (LayoutInflater) c
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            row = inflater.inflate(R.layout.row_layout, parent,
                    false);
        } else {
            row = convertView;
        }
        String[] detail = arrayList.get(position);


        RelativeLayout rl= (RelativeLayout)row.findViewById(R.id.rl);
        rl.setBackgroundColor(Color.parseColor(detail[3]));
        TextView name = (TextView) row.findViewById(R.id.primary_textview);
        name.setText(detail[0]);
        TextView email = (TextView) row.findViewById(R.id.textView);
        email.setText(detail[1]);

        return row;
    }

}
