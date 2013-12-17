package com.journaldev.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsUtil {

	public static void main(String[] args) {
		
		//Before Java 5 - Start
		List list = new ArrayList();
		list.add("abc");
		list.add(new Integer(5)); //OK
		
		for(Object obj : list){
			String str=(String) obj; //type casting leading to ClassCastException at runtime
		}
		//Before Java 5 - End
		
		//Using Generics in Collection classes
		List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>(); 
		list1.add("abc");
		//list1.add(new Integer(5)); //compiler error
		
		for(String str : list1){
			//no type casting needed, avoids ClassCastException
		}
	}

}
