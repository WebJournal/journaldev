package com.journaldev.serialization.inheritance;

import java.io.IOException;

import com.journaldev.serialization.SerializationUtil;

public class InheritanceSerializationTest {

	public static void main(String[] args) {
		String fileName = "subclass.ser";
		
		SubClass subClass = new SubClass();
		subClass.setId(10);
		subClass.setValue("Data");
		subClass.setName("Pankaj");
		
		try {
			SerializationUtil.serialize(subClass, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			SubClass subNew = (SubClass) SerializationUtil.deserialize(fileName);
			System.out.println("SubClass read = "+subNew);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
