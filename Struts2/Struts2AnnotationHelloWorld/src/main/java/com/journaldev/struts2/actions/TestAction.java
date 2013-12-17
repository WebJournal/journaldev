package com.journaldev.struts2.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/Test")
@Action("test")
@ResultPath("/jsps")
@Result(location="login.jsp")
public class TestAction extends ActionSupport {

}
