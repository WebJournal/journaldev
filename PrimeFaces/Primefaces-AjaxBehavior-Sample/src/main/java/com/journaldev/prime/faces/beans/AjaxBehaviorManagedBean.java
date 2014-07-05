package com.journaldev.prime.faces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class AjaxBehaviorManagedBean {
	private String message = "";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void keyUpListener(AjaxBehaviorEvent e){
		// Print out event information
		System.out.println("AjaxBehavior Listener :: "+e.getBehavior()+" :: "+e.getSource());
		// Throw NullPointerException
		throw new NullPointerException("Anonymous Null Pointer");
	}

}
