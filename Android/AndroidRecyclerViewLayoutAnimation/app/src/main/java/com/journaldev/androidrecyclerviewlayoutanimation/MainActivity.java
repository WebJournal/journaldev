package com.journaldev.androidrecyclerviewlayoutanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> arrayList = new ArrayList<>();


    int[] animationList = {R.anim.layout_animation_up_to_down, R.anim.layout_animation_right_to_left, R.anim.layout_animation_down_to_up, R.anim.layout_animation_left_to_right};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recyclerView);
        populateData();
        initAdapter();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i < animationList.length - 1) {
                    i++;
                } else {
                    i = 0;
                }
                runAnimationAgain();

            }
        });


    }

    private void populateData() {

        for (int i = 0; i < 12; i++) {
            arrayList.add("Item " + i);
        }
    }

    private void initAdapter() {
        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void runAnimationAgain() {




        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(this, animationList[i]);

        recyclerView.setLayoutAnimation(controller);
        recyclerViewAdapter.notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();

    }
}
