package com.journaldev.nearbyplaces;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anupamchugh on 09/09/16.
 */
public class PlacesPOJO {

    public class Root implements Serializable {

        @SerializedName("results")
        public List<CustomA> customA = new ArrayList<>();
        @SerializedName("status")
        public String status;
    }

    public class CustomA implements Serializable {


        @SerializedName("geometry")
        public Geometry geometry;
        @SerializedName("vicinity")
        public String vicinity;
        @SerializedName("name")
        public String name;

    }

    public class Geometry implements Serializable{

        @SerializedName("location")
        public LocationA locationA;

    }

    public class LocationA implements Serializable {

        @SerializedName("lat")
        public String lat;
        @SerializedName("lng")
        public String lng;


    }



}
