package com.journaldev.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	@Autowired
	private DataRequestScope dataRequestScope;
	
	@Autowired
	private DataSessionScope dataSessionScope;

	public DataRequestScope getDataRequestScope() {
		return dataRequestScope;
	}

	public void setDataRequestScope(DataRequestScope dataRequestScope) {
		this.dataRequestScope = dataRequestScope;
	}

	public DataSessionScope getDataSessionScope() {
		return dataSessionScope;
	}

	public void setDataSessionScope(DataSessionScope dataSessionScope) {
		this.dataSessionScope = dataSessionScope;
	}


}
