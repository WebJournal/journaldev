package com.journaldev.struts2.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyJavaBean {

	private String name;
	private boolean flag;
	private Integer age;
	private Date date;
	private String[] stocks;
	//roles array needs to initialize because it's used with index in form
	private String[] roles = new String[5];
	
	//do not preinitialize lists or any collections
	private List<Data> usersList;
	private List<Data> fruitsList;
	private Map<String, Data> usersMap;
	
	//custom type converter example
	private Rectangle rectangle;
	
	public List<Data> getFruitsList() {
		return fruitsList;
	}
	public void setFruitsList(List<Data> fruitsList) {
		this.fruitsList = fruitsList;
	}
	public List<Data> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<Data> users) {
		this.usersList = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String[] getStocks() {
		return stocks;
	}
	public void setStocks(String[] stocks) {
		this.stocks = stocks;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public Map<String, Data> getUsersMap() {
		return usersMap;
	}
	public void setUsersMap(Map<String, Data> usersMap) {
		this.usersMap = usersMap;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
}
