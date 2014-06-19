package com.journaldev.primefaces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.TabChangeEvent;

@ManagedBean
@SessionScoped
public class AccordionPanelManagedBean {

	private String journalMessage = "Welcome JournalDev !";
	private String componentMessage = "AccordionPanel Component !";

	public String getJournalMessage() {
		System.out.println("Journal Message Loaded");
		return journalMessage;
	}

	public void setJournalMessage(String journalMessage) {
		this.journalMessage = journalMessage;
	}

	public String getComponentMessage() {
		System.out.println("Component Message Loaded");
		return componentMessage;
	}

	public void setComponentMessage(String componentMessage) {
		this.componentMessage = componentMessage;
	}

	public void onChange(TabChangeEvent event) {
		System.out.println("Tab Changed :: You've Requested Seeing :: "+ event.getTab().getTitle());
	}

}
