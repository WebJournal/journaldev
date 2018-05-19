package com.journaldev.retrofitintro.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anupamchugh on 09/01/17.
 */

public class CreateUserResponse {

    @SerializedName("name")
    public String name;
    @SerializedName("job")
    public String job;
    @SerializedName("id")
    public String id;
    @SerializedName("createdAt")
    public String createdAt;
}
