package com.journaldev.java8.lambdas;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrimeTest {

	public static void main(String[] args) {
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));

	}

	//Declarative approach using lambdas, stream and predicate
	private static boolean isPrime(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1
				&& IntStream.range(2, number - 1).noneMatch(
						isDivisible);
	}
	
	//Declarative approach
//	private static boolean isPrime(int number) {		
//		return number > 1
//				&& IntStream.range(2, number - 1).noneMatch(
//						index -> number % index == 0);
//	}
	
	//Traditional approach
//	private static boolean isPrime(int number) {		
//		if(number < 2) return false;
//		for(int i=2; i<number; i++){
//			if(number % i == 0) return false;
//		}
//		return true;
//	}

}
