package com.journaldev.retrofitintro.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anupamchugh on 09/01/17.
 */

public class User {


    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }


}
