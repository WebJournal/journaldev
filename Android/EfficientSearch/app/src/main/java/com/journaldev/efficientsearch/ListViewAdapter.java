package com.journaldev.efficientsearch;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anupamchugh on 07/02/16.
 */
public class ListViewAdapter extends BaseAdapter implements Filterable {

    private List<Model> modelList;
    private List<Model> mStringFilterList;
    private ValueFilter valueFilter;

    private class ViewHolder {
        TextView vendorName;
    }

    public ListViewAdapter(List<Model> modelList) {
        this.modelList = modelList;
        mStringFilterList = modelList;
    }

    @Override
    public int getCount() {

        if (modelList != null)
            return modelList.size();
        else
            return 0;
    }

    @Override
    public Model getItem(int position) {

        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Model object = getItem(position);


        if (object.isCuisine) {
            return -1;
        } else
            return Integer.parseInt(object.id);
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        ViewHolder holder = null;
        Model vendorModel = getItem(position);


        if (vendorModel.isCuisine) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.row_null, null);

        } else {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_model, parent, false);
                holder = new ViewHolder();
                holder.vendorName = ((TextView) convertView.findViewById(R.id.txt_vendor_name));
                convertView.setTag(holder);

            } else {

                if (holder == null) {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_model, parent, false);
                    holder = new ViewHolder();
                    holder.vendorName = ((TextView) convertView.findViewById(R.id.txt_vendor_name));
                    convertView.setTag(holder);
                } else
                    holder = (ViewHolder) convertView.getTag();
            }

            holder.vendorName.setText(vendorModel.name);
            return convertView;
        }
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<Model> filterList = new ArrayList<>();


                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if (!mStringFilterList.get(i).isCuisine) {

                        if (mStringFilterList.get(i).cuisines.contains(constraint)) {
                            Model model = new Model(mStringFilterList.get(i).id, mStringFilterList.get(i).name, mStringFilterList.get(i).cuisines, false, -1);
                            filterList.add(model);
                        }
                    }
                }


                if (filterList.size() == 0) {

                    for (int i = 0; i < mStringFilterList.size(); i++) {
                        if ((mStringFilterList.get(i).name.toUpperCase())
                                .contains(constraint.toString().toUpperCase()) && !mStringFilterList.get(i).isCuisine) {

                            Model model = new Model(mStringFilterList.get(i).id, mStringFilterList.get(i).name, mStringFilterList.get(i).cuisines, false, -1);
                            if (!model.isCuisine)
                                filterList.add(model);
                        }
                    }
                }


                results.count = filterList.size();
                results.values = filterList;
            } else {

                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {

            modelList = (List<Model>) results.values;

            notifyDataSetChanged();
        }
    }
}
