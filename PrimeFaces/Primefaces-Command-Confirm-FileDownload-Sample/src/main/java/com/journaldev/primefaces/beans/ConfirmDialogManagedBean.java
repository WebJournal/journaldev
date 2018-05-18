package com.journaldev.primefaces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ConfirmDialogManagedBean {
	public String download(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Download In Progress ..."));
		return "";
	}
	
	public String save(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Save In Progress ..."));
		return "";
	}
}
