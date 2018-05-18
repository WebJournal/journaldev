package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mo1")
@SessionScoped
public class MobileObject {

	private String mlabel;
	private String mvalue;
	private String[] mob;

	public MobileObject() {
	}

	public MobileObject(String mlabel, String mvalue) {
		this.mlabel = mlabel;
		this.mvalue = mvalue;
	}

	public String getMlabel() {
		return mlabel;
	}

	public void setMlabel(String mlabel) {
		this.mlabel = mlabel;
	}

	public String getMvalue() {
		return mvalue;
	}

	public void setMvalue(String mvalue) {
		this.mvalue = mvalue;
	}

	public String[] getMob() {
		return mob;
	}

	public void setMob(String[] mob) {
		this.mob = mob;
	}

	public MobileObject[] m1;

	public MobileObject[] getM1() {
		return m1;
	}

	public void setM1(MobileObject[] m1) {
		this.m1 = m1;
	}

	public MobileObject[] getMobValue() {

		m1 = new MobileObject[4];
		m1[0] = new MobileObject("SonyErricson", "SonyErricson");
		m1[1] = new MobileObject("NokiaN72", "NokiaN72");
		m1[2] = new MobileObject("Xperia", "Xperia");
		m1[3] = new MobileObject("MicromaxCanvas", "MicromaxCanvas");
		return m1;
	}

}
