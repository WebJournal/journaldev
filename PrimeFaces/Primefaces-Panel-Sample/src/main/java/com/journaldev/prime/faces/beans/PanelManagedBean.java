package com.journaldev.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

@ManagedBean
@SessionScoped
public class PanelManagedBean {
	private String tutorial;
	private List<String> tutorials = new ArrayList<String>();

	public String getTutorial() {
		return tutorial;
	}

	public void setTutorial(String tutorial) {
		this.tutorial = tutorial;
	}
	
	public List<String> getTutorials() {
		return tutorials;
	}

	public void setTutorials(List<String> tutorials) {
		this.tutorials = tutorials;
	}

	public String search(){
		for(int i = 1 ; i < 11; i++){
			this.tutorials.add(this.tutorial+" Tutorial "+i);
		}
		return "";
	}
	
	public void toggleHandle(ToggleEvent event){
		System.out.println("Panel #"+event.getComponent().getId()+" Is Toggled");
	}
	
	public void closeHandle(CloseEvent event){
		System.out.println("Panel #"+event.getComponent().getId()+" Is Closed");
	}
}
