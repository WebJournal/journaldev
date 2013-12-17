package com.journaldev.string;

public class CharacterToString {

	/**
	 * Java class to convert Character to String
	 * @param args
	 */
	public static void main(String[] args) {
		char c = 'X';
		String str = String.valueOf(c);
		String str1 = Character.toString(c);
		System.out.println(c +" character converted to String using String.valueOf(char c)= "+str);
		System.out.println(c +" character converted to String using Character.toString(char c)= "+str1);
	}

}
