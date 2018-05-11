package com.journaldev.java.string;

public class CountNumberOfWordsInString {

	public static void main(String[] args) {
		
		countNumberOfWords("My name is Pankaj");
		countNumberOfWords("I Love Java Programming");
		countNumberOfWords(" This	is  not   properly formatted		line ");

	}

	private static void countNumberOfWords(String line) {
		//System.out.println(line.split(" ").length); //won't work with tabs and multiple spaces
		
		String trimmedLine = line.trim();
		int count = trimmedLine.isEmpty() ? 0 : trimmedLine.split("\\s+").length;
		
		System.out.println(count);
	}

}
