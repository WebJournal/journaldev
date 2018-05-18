package com.journaldev.validator.hibernate.model;

import javax.validation.constraints.NotNull;

public class MyBean {

	private String name;

	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
