package com.journaldev.prime.faces.data;

public class Document {
	private String name;
	private String id;
	private String author;
	
	public Document(String name, String id,String author){
		this.name = name;
		this.id = id;
		this.author = author;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
