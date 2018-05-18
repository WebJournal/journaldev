package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SelectBooleanButton {
	private boolean status;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String displaySystemStatus(){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Your System Is: "+(status == true ? "Truned On":"Turned Off")));
		return "";
	}
}
