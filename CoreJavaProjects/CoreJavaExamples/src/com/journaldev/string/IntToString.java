package com.journaldev.string;

public class IntToString {

	/**
	 * This class shows how to convert int to String
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10;
		int j = 0xEF;
		int k = 0123;
		int l = 0b111;
		String str = "" +i;
		String str1 = String.valueOf(j);
		String str2 = String.format("%d", k);
		String str3 = "" +l;
		
		System.out.println(i+" decimal int to String "+str);
		System.out.println(j+" hexadecimal int to String "+str1);
		System.out.println(k+" octal int to String "+str2);
		System.out.println(l+" binary int to String "+str3);
	}

}
