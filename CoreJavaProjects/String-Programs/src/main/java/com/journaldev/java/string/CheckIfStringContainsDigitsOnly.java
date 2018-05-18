package com.journaldev.java.string;

public class CheckIfStringContainsDigitsOnly {

	public static void main(String[] args) {
		digitsOnlyString("111");
		digitsOnlyString("111a 1");
		digitsOnlyString("111 222");
		digitsOnlyString("111L");

	}

	private static void digitsOnlyString(String string) {
		if(string.matches("\\d+")) System.out.println("Digit Only String ::"+string);
		
		try {
			Long.parseLong(string);
			System.out.println("Digit Only String ::"+string);
		}catch(Exception e){
			System.out.println("Non Digit Only String ::"+string);
		}
		
	}

}
