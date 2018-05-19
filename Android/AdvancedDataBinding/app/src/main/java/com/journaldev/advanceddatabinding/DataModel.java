package com.journaldev.advanceddatabinding;

import android.provider.ContactsContract;

/**
 * Created by anupamchugh on 07/07/16.
 */
public class DataModel {


    String name;
    int image;
    String summary;


    public DataModel(int image, String name, String summary) {

        this.name = name;
        this.summary = summary;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}



