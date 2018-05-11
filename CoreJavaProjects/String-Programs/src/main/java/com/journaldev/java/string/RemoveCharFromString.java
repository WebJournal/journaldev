package com.journaldev.java.string;

public class RemoveCharFromString {

	public static void main(String[] args) {

		removeCharFromString("abcbcdjfkd", 'c');
		removeCharFromString("Pankaj", 'a');
		removeCharFromString("ç∂©∂ç", '©');

	}

	private static void removeCharFromString(String input, char c) {
		String result = input.replaceAll(String.valueOf(c), "");
		System.out.println(result);
	}

}
