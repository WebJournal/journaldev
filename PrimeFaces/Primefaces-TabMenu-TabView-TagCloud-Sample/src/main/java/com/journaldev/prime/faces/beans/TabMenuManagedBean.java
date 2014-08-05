package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TabMenuManagedBean {
	private int index = 0;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}



	public String doSomeWork(){
		// Do some work
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Some Work Achieved"));
		// Change the index that TabMenu refers as activated tab
		index = 1;
		return "";
	}
}
