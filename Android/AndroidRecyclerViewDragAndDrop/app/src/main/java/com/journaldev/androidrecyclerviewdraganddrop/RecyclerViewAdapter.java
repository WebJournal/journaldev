package com.journaldev.androidrecyclerviewdraganddrop;

import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements ItemMoveCallback.ItemTouchHelperContract {

    private ArrayList<String> data;

    private final StartDragListener mStartDragListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        View rowView;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            rowView = itemView;
            mTitle = itemView.findViewById(R.id.txtTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public RecyclerViewAdapter(ArrayList<String> data, StartDragListener startDragListener) {
        mStartDragListener = startDragListener;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mTitle.setText(data.get(position));

        holder.imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() ==
                        MotionEvent.ACTION_DOWN) {
                    mStartDragListener.requestDrag(holder);
                }
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public void onRowMoved(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRowSelected(MyViewHolder myViewHolder) {
        myViewHolder.rowView.setBackgroundColor(Color.GRAY);

    }

    @Override
    public void onRowClear(MyViewHolder myViewHolder) {
        myViewHolder.rowView.setBackgroundColor(Color.WHITE);

    }
}

