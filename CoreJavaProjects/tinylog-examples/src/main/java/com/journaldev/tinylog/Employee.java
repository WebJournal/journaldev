package com.journaldev.tinylog;

import org.tinylog.Logger;

public class Employee {

	private int id;
	private String name;

	public String getName() {
		Logger.debug("Returning employee name " + this.name);
		return name;
	}

	public void setName(String name) {
		Logger.info("Setting employee name " + name);
		this.name = name;
	}

	public int getId() {
		Logger.debug("Returning employee id " + this.id);
		return id;
	}

	public void setId(int id) {
		Logger.info("Setting employee id " + id);
		this.id = id;
	}
}
