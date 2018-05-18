package com.journaldev.java8.defaultmethod;

@FunctionalInterface
public interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}
