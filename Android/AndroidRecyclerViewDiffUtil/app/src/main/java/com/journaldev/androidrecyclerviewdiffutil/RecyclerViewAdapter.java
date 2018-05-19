package com.journaldev.androidrecyclerviewdiffutil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CryptoViewHolder> {

    private ArrayList<Model> data;

    public class CryptoViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mPrice;

        public CryptoViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.txtName);
            mPrice = itemView.findViewById(R.id.txtPrice);
        }
    }

    public RecyclerViewAdapter(ArrayList<Model> data) {
        this.data = data;
    }

    @Override
    public CryptoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_layout, parent, false);
        return new CryptoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CryptoViewHolder holder, int position) {
        holder.mName.setText(data.get(position).name);
        holder.mPrice.setText(data.get(position).price + " USD");
    }

    @Override
    public void onBindViewHolder(CryptoViewHolder holder, int position, List<Object> payloads) {

        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
        } else {
            Bundle o = (Bundle) payloads.get(0);
            for (String key : o.keySet()) {
                if (key.equals("price")) {
                    holder.mName.setText(data.get(position).name);
                    holder.mPrice.setText(data.get(position).price + " USD");
                    holder.mPrice.setTextColor(Color.GREEN);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public ArrayList<Model> getData() {
        return data;
    }

    public void setData(ArrayList<Model> newData) {

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffUtilCallBack(newData, data));
        diffResult.dispatchUpdatesTo(this);
        data.clear();
        this.data.addAll(newData);
    }
}
