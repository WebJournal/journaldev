package com.journaldev.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@ManagedBean
@SessionScoped
public class TabViewManagedBean {
	private int index = 0;
	private String messageNum1 = "Tab#1 Content Is Loaded";
	private String messageNum2 = "Tab#2 Content Is Loaded";
	
	public String getMessageNum1() {
		System.out.println(messageNum1);
		return messageNum1;
	}

	public void setMessageNum1(String messageNum1) {
		this.messageNum1 = messageNum1;
	}

	public String getMessageNum2() {
		System.out.println(messageNum2);
		return messageNum2;
	}

	public void setMessageNum2(String messageNum2) {
		this.messageNum2 = messageNum2;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void onTabChanged(TabChangeEvent e){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tab With Index :: "+e.getTab().getTitle()+" Is Changed"));
	}
	
	public void onTabClosed(TabCloseEvent e){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tab With Index :: "+e.getTab().getTitle()+" Is Closed"));
	}
}
