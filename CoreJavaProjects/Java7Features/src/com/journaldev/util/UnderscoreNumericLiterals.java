package com.journaldev.util;

public class UnderscoreNumericLiterals {

	public static void main(String[] args) {
		int _10=0;
		int x = _10;
		long ccNumber = 1234_5678_9012_3456L;
		long ssn = 999_99_9999L;
		float pi = 	3.14_15F;
		long hexadecimalBytes = 0xFF_EC_DE_5E;
		long hexadecimalWords = 0xCAFE_BABE;
		long maxOfLong = 0x7fff_ffff_ffff_ffffL;
		byte byteInBinary = 0b0010_0101;
		long longInBinary = 0b11010010_01101001_10010100_10010010;
		int add = 12_3 + 3_2_1;
		System.out.println("ccNumber="+ccNumber);
		System.out.println("ssn="+ssn);
		System.out.println("pi="+pi);
		System.out.println("hexadecimalBytes="+hexadecimalBytes);
		System.out.println("hexadecimalWords="+hexadecimalWords);
		System.out.println("maxOfLong="+maxOfLong);
		System.out.println("byteInBinary="+byteInBinary);
		System.out.println("longInBinary="+longInBinary);
		System.out.println("add="+add);
		
		Integer.parseInt("12_3");
	}

}
