package com.journaldev.string;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JDK 11 New Functions in String class
 * 
 * @author pankaj
 *
 */
public class JDK11StringFunctions {

	public static void main(String[] args) {
		// isBlank()
		String s = "abc";
		System.out.println(s.isBlank());
		s = "";
		System.out.println(s.isBlank());

		// lines()
		String s1 = "Hi\nHello\rHowdy";
		System.out.println(s1);
		List<String> lines = s1.lines().collect(Collectors.toList());
		System.out.println(lines);

		// strip(), stripLeading(), stripTrailing()
		String s2 = "  Java,  \tPython\t ";
		System.out.println("#" + s2 + "#");
		System.out.println("#" + s2.strip() + "#");
		System.out.println("#" + s2.stripLeading() + "#");
		System.out.println("#" + s2.stripTrailing() + "#");

		// repeat()
		String s3 = "Hello\n";
		System.out.println(s3.repeat(3));
		s3 = "Co";
		System.out.println(s3.repeat(2));

	}

}
