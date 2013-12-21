package com.journaldev.struts2.exception;

import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(){
		throw new NullPointerException("Mandatory data missing");
	}
}
