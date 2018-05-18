package com.journaldev.regex;

import java.util.regex.*;

public class PatternExample {

	public static void main(String[] args) throws InterruptedException {
//		Pattern pattern = Pattern.compile(".xx.");
//		Matcher matcher = pattern.matcher("MxxY");
//		System.out.println("Input String matches regex - "+matcher.matches());
		// bad regular expression
		//Thread.sleep(100);
		//pattern = Pattern.compile("*xx*");

//		String str = "bbb";
//		System.out.println("Using String matches method: "+str.matches(".bb"));
//		System.out.println("Using Pattern matches method: "+Pattern.matches(".bb", str));
//		System.out.println(Pattern.matches("ad.$", "ade"));
//		System.out.println(Pattern.matches("^d.", "ada"));
//		System.out.println(Pattern.matches("d.", "da"));
//		System.out.println(Pattern.matches("[ab]x", "cx"));
//		System.out.println(Pattern.matches("^[abc]d.", "ad9"));
//		System.out.println(Pattern.matches("[ab].d$", "bad"));
//		System.out.println(Pattern.matches("[ab]x", "cx"));
//		System.out.println(Pattern.matches("..", ".a"));
//		System.out.println(Pattern.matches("[ab][12].", "a2#"));
//		System.out.println(Pattern.matches("[ab]..[12]", "acd2"));
//		System.out.println(Pattern.matches("[ab][12]", "c2"));
//		System.out.println(Pattern.matches("[^ab][^12].", "c3#"));
//		System.out.println(Pattern.matches("[^ab]..[^12]", "xcd3"));
//		System.out.println(Pattern.matches("[^ab][^12]", "c2"));
//		System.out.println(Pattern.matches("[a-e1-3].", "d#"));
//		System.out.println(Pattern.matches("[a-e1-3]", "2"));
//		System.out.println(Pattern.matches("[a-e1-3]", "f2"));
//		System.out.println(Pattern.matches("x.|y", "xa"));
//		System.out.println(Pattern.matches("x.|y", "y"));
//		System.out.println(Pattern.matches("x.|y", "yz"));
//		System.out.println(Pattern.matches("[a-zA-Z_0-9]", "9"));
		
		System.out.println(Pattern.matches("(\\w\\d)\\1", "a2a2")); //true
		System.out.println(Pattern.matches("(\\w\\d)\\1", "a2b2")); //false
		System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B2AB")); //true
		System.out.println(Pattern.matches("(AB)(B\\d)\\2\\1", "ABB2B3AB")); //false
	}

}
