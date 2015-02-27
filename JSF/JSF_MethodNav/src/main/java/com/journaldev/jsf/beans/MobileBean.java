package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MobileBean {

	private String mname;
	private String modelno;
	private String color;

	public MobileBean() {
	}

	public MobileBean(String mname, String modelno, String color) {
		this.mname = mname;
		this.modelno = modelno;
		this.color = color;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getModelno() {
		return modelno;
	}

	public void setModelno(String modelno) {
		this.modelno = modelno;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String add() {
		return "for";
	}

}
