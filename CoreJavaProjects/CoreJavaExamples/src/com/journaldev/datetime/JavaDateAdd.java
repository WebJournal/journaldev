package com.journaldev.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JavaDateAdd {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("Todays date: "+date.toString());
		//test addDays method
		int i=10;
		while(i<=50){
			Date newDate = addDays(date, i);
			System.out.println("Java Date after adding "+i+" days: "+newDate.toString());
			i+=10;
		}
		System.out.println("\n\n");
		//test subtractDays method
		i=10;
		while(i<=50){
			Date newDate = subtractDays(date, i);
			System.out.println("Java Date after subtracting "+i+" days: "+newDate.toString());
			i+=10;
		}

	}
	/**
	 * add days to date in java
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	
	/**
	 * subtract days to date in java
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
				
		return cal.getTime();
	}

}
