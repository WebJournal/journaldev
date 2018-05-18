package com.journaldev.java.tricky.collections;

import java.util.HashSet;

public class TestCollections {

	/**
	 * Output explained at below URL:
	 * https://www.journaldev.com/370/java-programming-interview-questions
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet shortSet = new HashSet();
		for (short i = 0; i < 100; i++) {
			shortSet.add(i);
			shortSet.remove(i - 1);
		}
		//what will be the output?
		System.out.println(shortSet.size());
	}
}
