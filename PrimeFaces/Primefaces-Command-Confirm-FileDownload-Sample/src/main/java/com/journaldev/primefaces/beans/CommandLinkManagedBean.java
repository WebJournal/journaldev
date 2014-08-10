package com.journaldev.primefaces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CommandLinkManagedBean {
	public String doSomeAction(){
		System.out.println("CommandLink is used");
		return "";
	}
}
