package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "car_gen", eager = true)
@RequestScoped
public class Car_gen {

	@ManagedProperty(value = "#{alto_car}")
	private Alto alto;

	private String description;

	public Car_gen() {
	}

	public String getDescription() {
		description = alto.getDescription();
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Alto getAlto() {
		return alto;
	}

	public void setAlto(Alto alto) {
		this.alto = alto;
	}

}
