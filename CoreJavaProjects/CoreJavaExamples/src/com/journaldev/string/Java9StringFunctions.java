package com.journaldev.string;

import java.util.Arrays;
import java.util.List;

public class Java9StringFunctions {

	public static void main(String[] args) {
		String s = "abc";

		// codePoints()
		s.codePoints().forEach(x -> System.out.println(x));

		// chars()
		s.chars().forEach(x -> System.out.println(x));
		
		//java-8 join()
		List<String> words = Arrays.asList(new String[]{"Hello", "World", "2019"});
		String msg = String.join(" ", words);
		System.out.println(msg);
	}

}
