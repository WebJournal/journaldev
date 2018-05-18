package com.journaldev.struts2.actions;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.journaldev.struts2.beans.User;
import com.opensymphony.xwork2.Action;

@org.apache.struts2.convention.annotation.Action("loginObject")
@Namespace("/")
@ResultPath("/")
@Results({ @Result(name = "success", location = "homeObject.jsp"),
		@Result(name = "input", location = "loginObject.jsp") })
public class LoginObjectBackedAction implements Action {

	@Override
	public String execute() throws Exception {
		if("pankaj".equals(getUser().getUserID()) && "admin".equals(getUser().getPassword())){
			getUser().setUserName("Pankaj Kumar");
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
