package com.journaldev.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

	/**
	 * Utility function to convert java Date to TimeZone format
	 * @param date
	 * @param format
	 * @param timeZone
	 * @return
	 */
	public static String formatDateToString(Date date, String format,
			String timeZone) {
		// null check
		if (date == null) return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		// return Date in required format with timezone as String
		return sdf.format(date);
	}

	public static void main(String[] args) {
		//Test formatDateToString method
		Date date = new Date();
		System.out.println("Default Date:"+date.toString());
		System.out.println("System Date: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", null));
		System.out.println("System Date in PST: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "PST"));
		System.out.println("System Date in IST: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "IST"));
		System.out.println("System Date in GMT: "+formatDateToString(date, "dd MMM yyyy hh:mm:ss a", "GMT"));
	}

}
