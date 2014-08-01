package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TieredMenuManagedBean {
	public String ajaxAction(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ajax Update"));
		return "";
	}
	
	public String nonAjaxAction(){
		return "";
	}
}
