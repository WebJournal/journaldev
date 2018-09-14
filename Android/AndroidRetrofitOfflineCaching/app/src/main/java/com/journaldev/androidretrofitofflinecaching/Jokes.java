package com.journaldev.androidretrofitofflinecaching;

import com.google.gson.annotations.SerializedName;

public class Jokes {


    @SerializedName("url")
    public String url;
    @SerializedName("icon_url")
    public String icon_url;
    @SerializedName("value")
    public String value;
}
