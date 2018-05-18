package com.journaldev.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -1273531583006208372L;
	
	@Override
	public String execute(){
		return SUCCESS;
	}
	
	@Override
	public void validate(){
		if("".equals(getName())){
			addFieldError("name", "UserName can't be empty");
		}
		if("".equals(getPwd())){
			addFieldError("pwd", "Password can't be empty");
		}
	}
	
	//Java Bean to hold the form parameters
		private String name;
		private String pwd;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
}
