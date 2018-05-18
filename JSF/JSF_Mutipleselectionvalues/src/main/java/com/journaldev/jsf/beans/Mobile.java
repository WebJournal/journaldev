package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mobile", eager = true)
@SessionScoped
public class Mobile {

	public String[] mobname;

	public String[] getMobname() {
		return mobname;
	}

	public void setMobname(String[] mobname) {
		this.mobname = mobname;
	}

}
