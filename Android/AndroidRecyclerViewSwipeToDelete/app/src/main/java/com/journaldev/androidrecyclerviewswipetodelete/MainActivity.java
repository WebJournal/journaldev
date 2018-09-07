package com.journaldev.androidrecyclerviewswipetodelete;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    ArrayList<String> stringArrayList = new ArrayList<>();
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        populateRecyclerView();
        enableSwipeToDeleteAndUndo();


    }

    private void populateRecyclerView() {
        stringArrayList.add("Item 1");
        stringArrayList.add("Item 2");
        stringArrayList.add("Item 3");
        stringArrayList.add("Item 4");
        stringArrayList.add("Item 5");
        stringArrayList.add("Item 6");
        stringArrayList.add("Item 7");
        stringArrayList.add("Item 8");
        stringArrayList.add("Item 9");
        stringArrayList.add("Item 10");

        mAdapter = new RecyclerViewAdapter(stringArrayList);
        recyclerView.setAdapter(mAdapter);


    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAdapterPosition();
                final String item = mAdapter.getData().get(position);

                mAdapter.removeItem(position);


                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        mAdapter.restoreItem(item, position);
                        recyclerView.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }


}
