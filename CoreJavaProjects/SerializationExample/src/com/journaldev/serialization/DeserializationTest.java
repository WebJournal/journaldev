package com.journaldev.serialization;

import java.io.IOException;

public class DeserializationTest {

	public static void main(String[] args) {

		String fileName="employee.ser";
		Employee empNew = null;
		
		try {
			empNew = (Employee) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("empNew Object::"+empNew);
		
	}

}
