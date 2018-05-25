package com.journaldev.androidlivedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.journaldev.androidlivedata.db.DbSettings;
import com.journaldev.androidlivedata.db.FavouritesDBHelper;
import java.util.ArrayList;
import java.util.List;

public class FavouritesViewModel extends AndroidViewModel {

    private FavouritesDBHelper mFavHelper;
    private MutableLiveData<List<Favourites>> mFavs;

    FavouritesViewModel(Application application) {
        super(application);
        mFavHelper = new FavouritesDBHelper(application);
    }

    public MutableLiveData<List<Favourites>> getFavs() {
        if (mFavs == null) {
            mFavs = new MutableLiveData<>();
            loadFavs();
        }

        return mFavs;
    }

    private void loadFavs() {
        List<Favourites> newFavs = new ArrayList<>();
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
            newFavs.add(new Favourites(cursor.getLong(idxId), cursor.getString(idxUrl), cursor.getLong(idxDate)));
        }

        cursor.close();
        db.close();
        mFavs.setValue(newFavs);
    }


    public void addFav(String url, long date) {

        SQLiteDatabase db = mFavHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbSettings.DBEntry.COL_FAV_URL, url);
        values.put(DbSettings.DBEntry.COL_FAV_DATE, date);
        long id = db.insertWithOnConflict(DbSettings.DBEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();


        List<Favourites> favourites = mFavs.getValue();

        ArrayList<Favourites> clonedFavs;
        if (favourites == null) {
            clonedFavs = new ArrayList<>();
        } else {
            clonedFavs = new ArrayList<>(favourites.size());
            for (int i = 0; i < favourites.size(); i++) {
                clonedFavs.add(new Favourites(favourites.get(i)));
            }
        }

        Favourites fav = new Favourites(id, url, date);
        clonedFavs.add(fav);
        mFavs.setValue(clonedFavs);
    }

    public void removeFav(long id) {
        SQLiteDatabase db = mFavHelper.getWritableDatabase();
        db.delete(
                DbSettings.DBEntry.TABLE,
                DbSettings.DBEntry._ID + " = ?",
                new String[]{Long.toString(id)}
        );
        db.close();

        List<Favourites> favs = mFavs.getValue();
        ArrayList<Favourites> clonedFavs = new ArrayList<>(favs.size());
        for (int i = 0; i < favs.size(); i++) {
            clonedFavs.add(new Favourites(favs.get(i)));
        }

        int index = -1;
        for (int i = 0; i < clonedFavs.size(); i++) {
            Favourites favourites = clonedFavs.get(i);
            if (favourites.mId == id) {
                index = i;
            }
        }
        if (index != -1) {
            clonedFavs.remove(index);
        }
        mFavs.setValue(clonedFavs);
    }

}
