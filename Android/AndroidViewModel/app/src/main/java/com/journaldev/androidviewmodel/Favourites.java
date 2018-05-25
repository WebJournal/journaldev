package com.journaldev.androidviewmodel;

public class Favourites {

    public long mId;
    public String mUrl;
    public long mDate;

    public Favourites(long id, String name, long date) {
        mId = id;
        mUrl = name;
        mDate = date;
    }

    public Favourites(Favourites favourites) {
        mId = favourites.mId;
        mUrl = favourites.mUrl;
        mDate = favourites.mDate;
    }

}