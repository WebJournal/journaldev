package com.journaldev.java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class NumberTest {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 15);

		// find max odd number in the range 3 to 11 and square it
		System.out.println(findSquareOfMaxOdd(numbers));
	}

	// private static int findSquareOfMaxOdd(List<Integer> numbers) {
	// int max = 0;
	// for(int i : numbers){
	// if(i%2 != 0 && i > 3 && i < 11 && i > max){
	// max =i;
	// }
	// }
	// return max*max;
	// }

	private static int findSquareOfMaxOdd(List<Integer> numbers) {
		return numbers.stream()
				.filter(NumberTest::isOdd) 			//Predicate is functional interface and
				.filter(i -> NumberTest.isGreaterThan3(i))	// we are using lambdas to initialize it
				.filter(NumberTest::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}
	
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
	

}
