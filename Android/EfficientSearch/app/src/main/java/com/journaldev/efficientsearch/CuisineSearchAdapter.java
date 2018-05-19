package com.journaldev.efficientsearch;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class CuisineSearchAdapter extends RecyclerView.Adapter<CuisineSearchAdapter.MyViewHolder> {

    Context mContext;
    ItemListener mListener;
    String prefix = "";
    private List<Model> allVendors, cuisines;


    public CuisineSearchAdapter(List<Model> cuisines, List<Model> vendorModels, Context context, ItemListener itemListener, String text) {
        this.allVendors = vendorModels;
        this.cuisines = cuisines;
        this.mContext = context;
        this.mListener = itemListener;
        prefix = text;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView icon;
        TextView textView;
        View parent;
        Model vendorModel;


        MyViewHolder(View itemView) {
            super(itemView);

            this.parent = itemView.findViewById(R.id.parentView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            this.icon = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }


        void setData(Model model, MyViewHolder holder) {

            textView = holder.textView;
            icon = holder.icon;
            this.vendorModel = model;

            if (prefix.length() > 0) {

                if (model.isCuisine) {
                    textView.setText(highlight(prefix, model.name + " (" + model.numberOfCuisine + ")"));
                    icon.setImageResource(R.mipmap.ic_local_offer);
                } else {
                    textView.setText(highlight(prefix, model.name));
                    icon.setImageResource(R.mipmap.ic_local_dining);
                }


            } else {

                if (model.isCuisine) {
                    textView.setText(model.name + " (" + model.numberOfCuisine + ")");
                    icon.setImageResource(R.mipmap.ic_local_offer);
                }
            }

        }

        @Override
        public void onClick(View view) {

            if (mListener != null) {
                mListener.onItemClick(vendorModel);
            }

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_list_row, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        if (prefix.length() > 0)
            holder.setData(allVendors.get(holder.getAdapterPosition()), holder);
        else
            holder.setData(cuisines.get(holder.getAdapterPosition()), holder);
    }


    @Override
    public int getItemCount() {

        if (prefix.length() > 0)
            return allVendors.size();
        else
            return cuisines.size();


    }

    private static CharSequence highlight(String search, String originalText) {
        // ignore case and accents
        // the same thing should have been done for the search text
        String normalizedText = Normalizer
                .normalize(originalText, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase(Locale.ENGLISH);

        int start = normalizedText.indexOf(search.toLowerCase(Locale.ENGLISH));
        if (start < 0) {
            // not found, nothing to to
            return originalText;
        } else {
            // highlight each appearance in the original text
            // while searching in normalized text
            Spannable highlighted = new SpannableString(originalText);
            while (start >= 0) {
                int spanStart = Math.min(start, originalText.length());
                int spanEnd = Math.min(start + search.length(),
                        originalText.length());

                highlighted.setSpan(new ForegroundColorSpan(Color.BLUE),
                        spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                start = normalizedText.indexOf(search, spanEnd);
            }

            return highlighted;
        }
    }

    public interface ItemListener {
        void onItemClick(Model model);
    }


}
