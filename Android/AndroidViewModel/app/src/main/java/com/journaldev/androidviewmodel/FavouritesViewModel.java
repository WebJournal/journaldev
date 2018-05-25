package com.journaldev.androidviewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.journaldev.androidviewmodel.db.DbSettings;
import com.journaldev.androidviewmodel.db.FavouritesDBHelper;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavouritesViewModel extends AndroidViewModel {

    private FavouritesDBHelper mFavHelper;
    private ArrayList<Favourites> mFavs;

    FavouritesViewModel(Application application) {
        super(application);
        mFavHelper = new FavouritesDBHelper(application);
    }

    public List<Favourites> getFavs() {
        if (mFavs == null) {
            mFavs = new ArrayList<>();

            createDummyList();
            loadFavs();
        }
        ArrayList<Favourites> clonedFavs = new ArrayList<>(mFavs.size());
        for (int i = 0; i < mFavs.size(); i++) {
            clonedFavs.add(new Favourites(mFavs.get(i)));
        }
        return clonedFavs;
    }

    public void createDummyList() {

        addFav("https://www.journaldev.com", (new Date()).getTime());
        addFav("https://www.medium.com", (new Date()).getTime());
        addFav("https://www.reddit.com", (new Date()).getTime());
        addFav("https://www.github.com", (new Date()).getTime());
        addFav("https://www.hackerrank.com", (new Date()).getTime());
        addFav("https://www.developers.android.com", (new Date()).getTime());
    }

    private void loadFavs() {

        mFavs.clear();

        SQLiteDatabase db = mFavHelper.getReadableDatabase();
        Cursor cursor = db.query(DbSettings.DBEntry.TABLE,
                new String[]{
                        DbSettings.DBEntry._ID,
                        DbSettings.DBEntry.COL_FAV_URL,
                        DbSettings.DBEntry.COL_FAV_DATE
                },
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idxId = cursor.getColumnIndex(DbSettings.DBEntry._ID);
            int idxUrl = cursor.getColumnIndex(DbSettings.DBEntry.COL_FAV_URL);
            int idxDate = cursor.getColumnIndex(DbSettings.DBEntry.COL_FAV_DATE);
            mFavs.add(new Favourites(cursor.getLong(idxId), cursor.getString(idxUrl), cursor.getLong(idxDate)));
        }
        cursor.close();
        db.close();
    }

    public Favourites addFav(String url, long date) {

        Log.d("API123", "addFav " + url);

        SQLiteDatabase db = mFavHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbSettings.DBEntry.COL_FAV_URL, url);
        values.put(DbSettings.DBEntry.COL_FAV_DATE, date);
        long id = db.insertWithOnConflict(DbSettings.DBEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        Favourites fav = new Favourites(id, url, date);
        mFavs.add(fav);
        return new Favourites(fav);
    }

    public void removeFav(long id) {
        SQLiteDatabase db = mFavHelper.getWritableDatabase();
        db.delete(
                DbSettings.DBEntry.TABLE,
                DbSettings.DBEntry._ID + " = ?",
                new String[]{Long.toString(id)}
        );
        db.close();

        int index = -1;
        for (int i = 0; i < mFavs.size(); i++) {
            Favourites favourites = mFavs.get(i);
            if (favourites.mId == id) {
                index = i;
            }
        }
        if (index != -1) {
            mFavs.remove(index);
        }
    }

}
