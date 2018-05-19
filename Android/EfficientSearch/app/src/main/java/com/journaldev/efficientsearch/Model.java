package com.journaldev.efficientsearch;

import java.util.List;

/**
 * Created by anupamchugh on 09/02/16.
 */
public class Model {


    public String name;
    public String id;
    public List<String> cuisines;
    public boolean isCuisine;
    public int numberOfCuisine;

    public Model(String id, String name, List<String> cuisines, boolean isCuisine, int numberOfCuisine) {

        this.name = name;
        this.id = id;
        this.cuisines = cuisines;
        this.isCuisine = isCuisine;
        this.numberOfCuisine = numberOfCuisine;
    }


}
