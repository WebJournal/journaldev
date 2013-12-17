package com.journaldev.inheritance;

public class ClassDComposition {

	ClassC classC = null;
	
	public ClassDComposition(){
		//this.classC = new ClassC();
	}
	
	public int test(){
		classC.test();
		return 0;
	}
}
