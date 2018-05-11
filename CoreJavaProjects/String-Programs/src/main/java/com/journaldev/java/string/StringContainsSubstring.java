package com.journaldev.java.string;

import java.util.Scanner;

public class StringContainsSubstring {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First String:");
		String s1 = scanner.nextLine();
		
		System.out.println("Enter Second String:");
		String s2 = scanner.nextLine();
		
		scanner.close();
		
		boolean result = stringContainsSubstring(s1, s2);
		System.out.println(s1+" contains "+s2+" = "+result);
	}

	private static boolean stringContainsSubstring(String string, String substring) {
		boolean result = false;
		result = string.contains(substring);
		return result;
	}

}
