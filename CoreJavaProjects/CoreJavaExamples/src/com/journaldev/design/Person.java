package com.journaldev.design;

//abstract class
public abstract class Person {
	
	private String name;
	private String gender;
	
	public Person(String nm, String gen){
		this.name=nm;
		this.gender=gen;
	}
	
	public void changeName(String nm){
		this.name=nm;
	}
	
	//abstract method
	public abstract void work();
	
	@Override
	public String toString(){
		return "Name="+this.name+"::Gender="+this.gender;
	}
	
}
