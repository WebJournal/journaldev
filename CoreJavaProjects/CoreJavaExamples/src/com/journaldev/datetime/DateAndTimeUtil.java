package com.journaldev.datetime;

import java.util.Calendar;
import java.util.Date;

public class DateAndTimeUtil {

	public static void main(String[] args) {
		//Get current date using Date
		Date date = new Date();
		System.out.println("Current date using Date = "+date.toString());

		//Get current date using Calendar
		Calendar cal = Calendar.getInstance();
		System.out.println("Current date using Calendar = "+cal.getTime());
		
		//Get current time in milliseconds
		System.out.println("Current time in milliseconds using Date = "+date.getTime());
		System.out.println("Current time in milliseconds using Calendar = "+cal.getTimeInMillis());
	}
	  

}
