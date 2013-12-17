package com.journaldev.string;

public class StringToInt {

	/** This class shows how to convert String to int
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "123"; //3*10^0 +2*10^1 + 1*10^2 
		//Hexadecimal format int as String
		String strHex = "EF"; // 16*16^0 + 15*16^1  
		//Octadecimal format int as String
		String strOct = "0123"; //3*8^0 + 2*8^1 + 1*8^2 + 0*8^3
		//Binary format int as String
		String strBinary = "111"; // 1*2^0 + 1*2^1 + 1*2^2
		//Some random String
		String strRandom = "ABC"; // 12*36^0 + 11*36^1 + 10*36^2
		String strRandomSmall = "abc"; // 12*36^0 + 11*36^1 + 10*36^2
		System.out.println("Minimum Radix = "+Character.MIN_RADIX);
		System.out.println("Minimum Radix = "+Character.MAX_RADIX);
		System.out.println(str +" String is converted to int = "+Integer.parseInt(str));
		System.out.println(strHex +" String is converted to int = "+Integer.parseInt(strHex, 16));
		System.out.println(strOct +" String is converted to int = "+Integer.parseInt(strOct, 8));
		System.out.println(strBinary +" String is converted to int = "+Integer.parseInt(strBinary, 2));
		System.out.println(strRandom +" String is converted to int = "+Integer.parseInt(strRandom, 36));
		System.out.println(strRandomSmall +" String is converted to int = "+Integer.parseInt(strRandomSmall, 36));
		//To create Integer object from String, supports only decimal
		System.out.println(str +" String is converted to int = "+Integer.valueOf(str));
	}

}
