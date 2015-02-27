package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Car {

	private String cname = "Polo";
	private String color = "White";
	private String modelno = "P245";

	public Car() {
	}

	public Car(String cname, String color, String modelno) {
		this.cname = cname;
		this.color = color;
		this.modelno = modelno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelno() {
		return modelno;
	}

	public void setModelno(String modelno) {
		this.modelno = modelno;
	}

	public float calculatespeed(float speed) {

		float totalspeed = speed + 10;
		return totalspeed;

	}

}
