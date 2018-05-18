package com.journaldev.java.tricky.string;

public class TestString {

	/**
	 * Output explained at below URL:
	 * https://www.journaldev.com/370/java-programming-interview-questions
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		
		//what will be the output?
		System.out.println("s1 == s2 is:" + s1 == s2);
		
		String s3 = "JournalDev";
		int start = 1;
		char end = 5;
		
		//what will be the output?
		System.out.println(start + end);
		System.out.println(s3.substring(start, end));
		
		
		String x = "abc";
		String y = "abc";
		x.concat(y);
		//what will be the output?
		System.out.print(x);
		
		String str = null;
		String str1="abc";
		//what will be the output?
		System.out.println(str1.equals("abc") | str.equals(null));
	}

}
