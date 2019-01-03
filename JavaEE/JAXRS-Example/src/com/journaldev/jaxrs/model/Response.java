package com.journaldev.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	private boolean status;
	private String message;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
