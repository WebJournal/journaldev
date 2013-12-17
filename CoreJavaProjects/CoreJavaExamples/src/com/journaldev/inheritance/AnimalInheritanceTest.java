package com.journaldev.inheritance;

import java.util.Calendar;
import java.util.Date;

public class AnimalInheritanceTest {

	public static void main(String[] args) {
		Cat cat = new Cat(false, "milk", 4, "black");

		System.out.println("Cat is vegetaring?" + cat.isVegetarian());
		System.out.println("Cat eats " + cat.getEats());
		System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
		System.out.println("Cat color is " + cat.getColor());
		
		Calendar cal = Calendar.getInstance();
		cal.set(1970, 0, 1, 0, 0, 0);
		Date date = cal.getTime();
	}

}
