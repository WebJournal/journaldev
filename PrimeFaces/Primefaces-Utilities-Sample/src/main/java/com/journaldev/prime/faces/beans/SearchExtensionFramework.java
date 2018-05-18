package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SearchExtensionFramework {
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

	public String doAction(){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Growl Component Updated and Referenced By Using SEF","Username: "
						+	this.username	+	" :: Password: "	+	password));
		return "";
	}
}
