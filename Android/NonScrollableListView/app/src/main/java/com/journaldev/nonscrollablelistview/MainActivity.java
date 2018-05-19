package com.journaldev.nonscrollablelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.listView)
    NonScrollListView nonScrollListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        final List<String[]> values = new LinkedList<String[]>();
        values.add(new String[]{"Title 1", "Subtitle 1"});
        values.add(new String[]{"Title 2", "Subtitle 2"});
        values.add(new String[]{"Title 3", "Subtitle 3"});
        values.add(new String[]{"Title 4", "Subtitle 4"});
        values.add(new String[]{"Title 5", "Subtitle 5"});
        values.add(new String[]{"Title 6", "Subtitle 6"});
        values.add(new String[]{"Title 7", "Subtitle 7"});
        values.add(new String[]{"Title 8", "Subtitle 8"});


        nonScrollListView.setAdapter(new ArrayAdapter<String[]>(MainActivity.this, android.R.layout.simple_expandable_list_item_2, android.R.id.text1, values) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);


                String[] entry = values.get(position);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText(entry[0]);
                text2.setText(entry[1]);

                return view;
            }
        });






    }

    @Nullable
    @OnClick({ R.id.header_button, R.id.button1,R.id.button2 , R.id.button3})
    public void commonMethod() {
        Toast.makeText(getApplicationContext(),"Button is clicked",Toast.LENGTH_SHORT).show();
    }

    @OnItemClick(R.id.listView)
    void onItemClick(int position) {
        Toast.makeText(getApplicationContext(),"Position "+position+" is clicked",Toast.LENGTH_SHORT).show();
    }

}
