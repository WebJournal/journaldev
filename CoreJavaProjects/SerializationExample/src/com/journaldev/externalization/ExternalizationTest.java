package com.journaldev.externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationTest {

	public static void main(String[] args) {
		
		String fileName = "person.ser";
		Person person = new Person();
		person.setId(1);
		person.setName("Pankaj");
		person.setGender("Male");
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(person);
		    oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Person p = (Person)ois.readObject();
		    ois.close();
		    System.out.println("Person Object Read="+p);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	}

}
