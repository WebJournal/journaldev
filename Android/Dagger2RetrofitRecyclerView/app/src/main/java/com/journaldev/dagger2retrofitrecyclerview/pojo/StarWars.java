package com.journaldev.dagger2retrofitrecyclerview.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StarWars {

    @SerializedName("results")
    public List<People> results = null;


    public class People {

        @SerializedName("name")
        public String name;
        @SerializedName("height")
        public String height;
        @SerializedName("mass")
        public String mass;
        @SerializedName("birth_year")
        public String birthYear;
        @SerializedName("gender")
        public String gender;
        @SerializedName("homeworld")
        public String homeworld;
        @SerializedName("films")
        public List<String> films = null;


    }

}
