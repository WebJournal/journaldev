package com.journaldev.java8.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JavaStreamSumExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
				12, 13, 14, 15);

		System.out.println("Iterator Sum=" + sumIterator(list));

		System.out.println("Stream API Sum=" + sumStream(list));
	}

	private static int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();

		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}

		}
		return sum;
	}

	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}

}
