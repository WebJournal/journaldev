package com.journaldev.prime.faces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BlockUIManagedBean {
	public String someAction() throws InterruptedException{
		Thread.currentThread().sleep(4000);
		return "";
	}
}
