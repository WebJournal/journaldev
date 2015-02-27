package com.journaldev.jsf.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Car implements Serializable {

	private static final long serialVersionUID = -4018866884298600517L;
	private String cname;
	private String color;
	private String Id;

	public Car() {
	}

	public Car(String cname, String color, String Id) {
		this.cname = cname;
		this.color = color;
		this.Id = Id;

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCname() {

		System.out.println("car name is" + cname);
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

}
