package com.journaldev.jsf.beans;

import java.util.ArrayList;
import java.util.List;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Car {
   
    private String carname;
    private List<Car> cars;

    public Car(String carname) {
        this.carname = carname;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public Car() {
    }
   
    public List<Car> getCars() {
        if (cars == null) {
            cars = new ArrayList<Car>();
            cars.add(new Car("Innova"));
            cars.add(new Car("Qualis"));
            cars.add(new Car("Scorpio"));
            cars.add(new Car("Xylo"));
        }
        return cars;
    }
 
}