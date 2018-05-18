package com.journaldev.primefaces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CommandButtonManagedBean {
	
	private String username = "";
	private String password = "";
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doSomeAction(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Message Updated !"));		
		// Do any action that you would.
		System.out.println("Entered Username :: "+username);
		System.out.println("Entered Password :: "+password);
		// Returns outcome
		return "";
	}
	
	public String updateMessage(){
		// Do any action that you would.
		System.out.println("Entered Username :: "+username);
		System.out.println("Entered Password :: "+password);		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Message Updated !"));
		return "";
	}
}
