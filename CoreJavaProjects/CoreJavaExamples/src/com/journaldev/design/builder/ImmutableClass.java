package com.journaldev.design.builder;

import java.util.HashMap;

public class ImmutableClass {
	
	//required fields
	private int id;
	private String name;
	
	//optional fields
	private HashMap<String, String> properties;
	private String company;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getProperties() {
		//return cloned object to avoid changing it by the client application
		return (HashMap<String, String>) properties.clone();
	}

	public String getCompany() {
		return company;
	}

	private ImmutableClass(ImmutableClassBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.properties = builder.properties;
		this.company = builder.company;
	}
	
	public static class ImmutableClassBuilder{
		//required fields
		private int id;
		private String name;
		
		//optional fields
		private HashMap<String, String> properties;
		private String company;
		
		public ImmutableClassBuilder(int i, String nm){
			this.id=i;
			this.name=nm;
		}
		
		public ImmutableClassBuilder setProperties(HashMap<String,String> hm){
			this.properties = (HashMap<String, String>) hm.clone();
			return this;
		}
		
		public ImmutableClassBuilder setCompany(String comp){
			this.company = comp;
			return this;
		}
		
		public ImmutableClass build(){
			return new ImmutableClass(this);
		}
	}
}
