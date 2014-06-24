package com.journaldev.primefaces.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class CalendarManagedBean {
	private Date date = new Date();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void dateSelectedAction(SelectEvent e){
		Date date = (Date)e.getObject();
		System.out.println("Date Selected Is ::"+date);
	}
		
	
}
