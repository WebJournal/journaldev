package com.journaldev.androidrecyclerviewdiffutil;

public class Model implements Comparable, Cloneable {

    public String name;
    public int id, price;

    public Model(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        Model compare = (Model) o;

        if (compare.id == this.id && compare.name.equals(this.name) && compare.price == (this.price)) {
            return 0;
        }
        return 1;
    }

    @Override
    public Model clone() {

        Model clone;
        try {
            clone = (Model) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); //should not happen
        }

        return clone;
    }

}
