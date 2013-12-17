package com.journaldev.struts2.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

@Action("home")
@ResultPath("/")
@Namespace("/")
@Result(location="home.jsp", name="success")
public class HomeAction{

	public String execute(){
		return "success";
	}
}
