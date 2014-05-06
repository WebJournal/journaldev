package com.journaldev.java8.staticmethod;

public class MyDataImpl implements MyData {

	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	public String toString(){
		
		return "";
	}
	public static void main(String args[]){
		MyData obj = new MyDataImpl();
		obj.print("");
		boolean result = MyData.isNull("abc");
	}
}
