package com.journaldev.design;

public interface Shape{

	//only public, static and final modifiers
	//implicitly final
	String LABLE="Shape";
	
	//interface methods are implicitly abstract and public
	void draw();
	
	double getArea();
}
