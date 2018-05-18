package com.journaldev.struts2.actions;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(HomeAction.class);
	
	public String execute(){
		logger.info("inside HomeAction execute method");
		return SUCCESS;
	}
}
