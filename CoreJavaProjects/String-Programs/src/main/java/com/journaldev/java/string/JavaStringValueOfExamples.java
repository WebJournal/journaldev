package com.journaldev.java.string;

public class JavaStringValueOfExamples {

	public static void main(String[] args) {
		Data obj = new Data(10);
		String str = String.valueOf(obj);
		System.out.println(str);

		char[] chars = { 'a', 'b', 'c' };
		String str1 = String.valueOf(chars);
		System.out.println(str1);

		String str2 = String.valueOf(chars, 1, 2);
		System.out.println(str2);

		boolean flag = true;
		String str3 = String.valueOf(flag);
		System.out.println(str3);

		char c = 65;
		String str4 = String.valueOf(c);
		System.out.println(str4);

		int i = 'A';
		String str5 = String.valueOf(i);
		System.out.println(str5);

		long l = 12345L;
		String str6 = String.valueOf(l);
		System.out.println(str6);

		float f = 123.45f;
		String str7 = String.valueOf(f);
		System.out.println(str7);

		double d = 123.45d;
		String str8 = String.valueOf(d);
		System.out.println(str8);

	}

}

class Data {
	private int id;

	public Data(int i) {
		this.id = i;
	}

	@Override
	public String toString() {
		return "Data{id:" + id + "}";
	}
}
