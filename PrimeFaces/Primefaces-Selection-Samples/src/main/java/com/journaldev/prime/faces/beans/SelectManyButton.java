package com.journaldev.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SelectManyButton {
	private List<String> tutorials = new ArrayList<String>();
	
	private List<String> selectedTutorials = new ArrayList<String>();

	
	@PostConstruct
	public void init(){
		this.tutorials = new ArrayList<String>();
		this.tutorials.add("Primefaces");
		this.tutorials.add("Hibernate");
		this.tutorials.add("Spring");
	}

	public List<String> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<String> tutorials) {
		this.tutorials = tutorials;
	}
	
	public List<String> getSelectedTutorials() {
		return selectedTutorials;
	}

	public void setSelectedTutorials(List<String> selectedTutorials) {
		this.selectedTutorials = selectedTutorials;
	}

	public String register(){
		String message = "";
		for(String s : this.selectedTutorials){
			message = message + s + ",";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've Registered In:", message));
		return "";
	}
}
