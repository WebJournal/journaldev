package com.journaldev.utils;

public class MathUtils {

	private Calculator calc;
	
	public MathUtils(Calculator c) {
		this.calc = c;
	}
	
	public int add(int i, int j) {
		return this.calc.add(i, j);
	}
	
	public int multiply(int i, int j) {
		return this.calc.multiply(i, j);
	}
}
