package com.journaldev.nearbyplaces;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


/**
 * Created by anupamchugh on 01/03/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private List<PlacesPOJO.CustomA> stLstStores;
    private List<StoreModel> models;


    public RecyclerViewAdapter(List<PlacesPOJO.CustomA> stores, List<StoreModel> storeModels) {

        stLstStores = stores;
        models = storeModels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_list_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.setData(stLstStores.get(holder.getAdapterPosition()), holder, models.get(holder.getAdapterPosition()));
    }


    @Override
    public int getItemCount() {
        return Math.min(5, stLstStores.size());
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView txtStoreName;
        TextView txtStoreAddr;
        TextView txtStoreDist;
        StoreModel model;


        public MyViewHolder(View itemView) {
            super(itemView);

            this.txtStoreDist = (TextView) itemView.findViewById(R.id.txtStoreDist);
            this.txtStoreName = (TextView) itemView.findViewById(R.id.txtStoreName);
            this.txtStoreAddr = (TextView) itemView.findViewById(R.id.txtStoreAddr);


        }


        public void setData(PlacesPOJO.CustomA info, MyViewHolder holder, StoreModel storeModel) {


            this.model = storeModel;

            holder.txtStoreDist.setText(model.distance + "\n" + model.duration);
            holder.txtStoreName.setText(info.name);
            holder.txtStoreAddr.setText(info.vicinity);


        }

    }
}
