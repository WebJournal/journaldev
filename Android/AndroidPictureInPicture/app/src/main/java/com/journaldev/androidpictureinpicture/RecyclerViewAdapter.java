package com.journaldev.androidpictureinpicture;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CryptoViewHolder> {

    private ArrayList<Model> videoList;
    private ItemListener mItemListener;

    public class CryptoViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private CardView cardView;

        public CryptoViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.txtName);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

    public RecyclerViewAdapter(ArrayList<Model> videoList, ItemListener itemListener) {
        this.videoList = videoList;
        this.mItemListener = itemListener;
    }

    @Override
    public CryptoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_row, parent, false);
        return new CryptoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CryptoViewHolder holder, final int position) {
        holder.mName.setText(videoList.get(position).name);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.onItemClick(videoList.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public interface ItemListener {
        void onItemClick(Model model);
    }

}
