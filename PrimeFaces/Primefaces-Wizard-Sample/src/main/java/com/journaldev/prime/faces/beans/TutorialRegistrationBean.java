package com.journaldev.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FlowEvent;

import com.journaldev.data.Tutorial;

@ManagedBean
@SessionScoped
public class TutorialRegistrationBean {
	
	private List<Tutorial> tutorials = new ArrayList<Tutorial>();
	private Tutorial tutorial = new Tutorial();

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	public List<Tutorial> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	
	public String register(){
		this.tutorials.add(tutorial);
		this.tutorial = new Tutorial();
		return "";
	}
	
	public String flowListener(FlowEvent event){
		System.out.println("Flow Event Happened :: New Step :: "+event.getNewStep()+" :: Old Step :: "+event.getOldStep());
		return event.getNewStep();
	}

}
