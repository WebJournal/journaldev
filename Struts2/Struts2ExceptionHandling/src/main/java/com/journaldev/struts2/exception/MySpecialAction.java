package com.journaldev.struts2.exception;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

public class MySpecialAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws IOException{
		throw new IOException("IOException occured");
	}
}
