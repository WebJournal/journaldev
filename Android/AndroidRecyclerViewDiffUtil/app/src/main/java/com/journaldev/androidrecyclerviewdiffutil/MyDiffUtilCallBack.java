package com.journaldev.androidrecyclerviewdiffutil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import java.util.ArrayList;

public class MyDiffUtilCallBack extends DiffUtil.Callback {
    ArrayList<Model> newList;
    ArrayList<Model> oldList;

    public MyDiffUtilCallBack(ArrayList<Model> newList, ArrayList<Model> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).id == oldList.get(oldItemPosition).id;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        return result == 0;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {

        Model newModel = newList.get(newItemPosition);
        Model oldModel = oldList.get(oldItemPosition);

        Bundle diff = new Bundle();

        if (newModel.price != (oldModel.price)) {
            diff.putInt("price", newModel.price);
        }
        if (diff.size() == 0) {
            return null;
        }
        return diff;
        //return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
