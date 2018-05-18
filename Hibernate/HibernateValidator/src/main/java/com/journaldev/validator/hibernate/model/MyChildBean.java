package com.journaldev.validator.hibernate.model;

import javax.validation.constraints.NotNull;

public class MyChildBean extends MyBean {

	private String data;

	@NotNull
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
