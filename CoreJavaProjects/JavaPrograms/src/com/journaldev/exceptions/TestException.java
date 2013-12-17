package com.journaldev.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TestException {

	public static void main(String[] args) {
		DateFormat df = DateFormat.getTimeInstance(2, Locale.getDefault());
		System.out.println(df.format(new Date()));
		try {
			testExceptions();
		}catch (IOException  e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void testExceptions() throws IOException, FileNotFoundException{
		
	}
}
