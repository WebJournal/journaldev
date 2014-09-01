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
public class SelectOneListbox {
	private List<String> tutorials = new ArrayList<String>();
	
	private String selectedTutorial = "";

	
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

	public String getSelectedTutorial() {
		return selectedTutorial;
	}

	public void setSelectedTutorial(String selectedTutorial) {
		this.selectedTutorial = selectedTutorial;
	}

	public String register(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You've Registered In:", this.selectedTutorial));
		return "";
	}
}
