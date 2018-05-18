package com.journaldev.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CustomExceptionExample {

	public static void main(String[] args) throws MyException {
		try {
			processFile(null);
		} catch (MyException e) {
			processErrorCodes(e);
		}
	
	}

	private static void processErrorCodes(MyException e) throws MyException {
		switch(e.getErrorCode()){
		case "BAD_FILE_TYPE":
			System.out.println("File Not Found, notify user");
			throw e;
		case "FILE_NOT_FOUND_EXCEPTION":
			System.out.println("File Not Found, notify user");
			throw e;
		case "FILE_CLOSE_EXCEPTION":
			System.out.println("File Close failed, just log it.");
			break;
		default:
			System.out.println("Unknown exception occured, lets log it for further debugging."+e.getMessage());
			e.printStackTrace();
		}
	}

	private static void processFile(String file) throws MyException {
		if(file == null) throw new MyException("File name can't be null", "NULL_FILE_NAME");
		
		InputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new MyException(e.getMessage(),"FILE_NOT_FOUND_EXCEPTION");
		}finally{
			try {
				if(fis !=null)fis.close();
			} catch (IOException e) {
				throw new MyException(e.getMessage(),"FILE_CLOSE_EXCEPTION");
			}
		}
	}

}
