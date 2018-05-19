package com.journaldev.swipetorefresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> arrayList = new ArrayList<>();
    SwipeRefreshLayout mSwipeRefreshLayout;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToRefresh);
        mListView = (ListView) findViewById(R.id.listView);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        arrayList.add("First Element");
        arrayList.add("Second Element");
        arrayList.add("Third Element");
        arrayList.add("Fourth Element");
        arrayList.add("Fifth Element");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        mListView.setAdapter(adapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                shuffle();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    public void shuffle(){
        Collections.shuffle(arrayList, new Random(System.currentTimeMillis()));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        mListView.setAdapter(adapter);

    }
}


