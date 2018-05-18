package com.journaldev.java.tricky;

public class TestBasics {

	/**
	 * Output explained at below URL:
	 * https://www.journaldev.com/370/java-programming-interview-questions
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		reachFinallyBlock(false);
		reachFinallyBlock(true);
	}

	public static void reachFinallyBlock(boolean flag){
		try {
			if (flag) {
				while (true) {
				}
			} else {
				System.exit(1);
			}
		} finally {
			System.out.println("In Finally");
		}
		}
}
