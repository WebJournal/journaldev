package com.journaldev.androidrecyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.journaldev.androidrecyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        populateData();
    }

    private void populateData() {
        List<DataModel> dataModelList = new ArrayList<>();

        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Pie", "9.0"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, this);
        binding.setMyAdapter(myRecyclerViewAdapter);
    }
}
