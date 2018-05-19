package com.journaldev.androidrecyclerviewdiffutil;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    FloatingActionButton fabAddList, fabChangeList;

    private ArrayList<Model> modelArrayList = new ArrayList<>();

    public int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fabAddList = findViewById(R.id.fabAddList);
        fabChangeList = findViewById(R.id.fabChangeList);

        dummyData();
        recyclerViewAdapter = new RecyclerViewAdapter(modelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerViewAdapter);

        fabAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMoreCoinsToTheList();
            }
        });

        fabChangeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePricesInTheList();
            }
        });

    }

    private void dummyData() {

        modelArrayList.add(new Model(i++, "Bitcoin", 8000));
        modelArrayList.add(new Model(i++, "Ethereum", 600));
        modelArrayList.add(new Model(i++, "Litecoin", 250));
        modelArrayList.add(new Model(i++, "Bitcoin Cash", 1000));
    }

    private void addMoreCoinsToTheList() {
        ArrayList<Model> models = new ArrayList<>();

        for (Model model : modelArrayList) {
            models.add(model.clone());
        }
        models.add(new Model(i++, "Tron", 1));
        models.add(new Model(i++, "Ripple", 5));
        models.add(new Model(i++, "NEO", 100));
        models.add(new Model(i++, "OMG", 20));

        recyclerViewAdapter.setData(models);
    }

    private void changePricesInTheList() {

        ArrayList<Model> models = new ArrayList<>();

        for (Model model : modelArrayList) {
            models.add(model.clone());
        }

        for (Model model : models) {
            if (model.price < 900)
                model.price = 900;
        }
        recyclerViewAdapter.setData(models);
    }

}
