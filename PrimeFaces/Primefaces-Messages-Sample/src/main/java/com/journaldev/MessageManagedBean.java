package com.journaldev;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MessageManagedBean {
	private String message ="";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String doSomeAction(){
		if(this.message.equals("")){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "<i>Error Message Displayed</i>","<i>Error Message Displayed</i>"));		
		}		
		return "";
	}
}
