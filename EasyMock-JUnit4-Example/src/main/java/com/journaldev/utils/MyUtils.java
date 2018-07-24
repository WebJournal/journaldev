package com.journaldev.utils;

public class MyUtils {

	private StringUtils su;
	private IntegerUtils iu;
	
	public MyUtils(StringUtils su, IntegerUtils iu) {
		this.su = su;
		this.iu = iu;
	}
	
	public int add(int i, int j) {
		return iu.add(i, j);
	}
	
	public String reverse(String s) {
		return su.reverse(s);
	}
	
	public String convert(int i) {
		return su.convert(i);
	}
}
