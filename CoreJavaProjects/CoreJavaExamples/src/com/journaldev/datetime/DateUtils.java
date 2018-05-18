package com.journaldev.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Java program example to convert String to Date and to convert Date to String
 * @author pankaj
 *
 */
public class DateUtils {
    public static void main(String[] args) {
    	//initialize SimpleDateFormat object
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
        try {
        	//Convert String to Date
            Date today = sdf.parse("14/11/2012");
            System.out.println("Date is:"+today.toString());
            
            //using locale
            sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.CANADA_FRENCH);
            today = new Date();
            System.out.println("Date is:"+today.toString());
            
            //Convert Date to String
            System.out.println(sdf.format(today));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}