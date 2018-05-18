package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "carnav", eager = true)
@RequestScoped
public class CarNav {

	@ManagedProperty(value = "#{param.pid}")
	private String pid;

	public String showPage() {
		if (pid == null) {
			return "car_nav";
		}
		if (pid.equals("1")) {
			return "pagenav";
		} else if (pid.equals("2")) {
			return "view";
		} else {
			return "car_nav";
		}
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
