package com.journaldev.randomnumber;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

public class RandomNumberExample {

	public static void main(String[] args) {
		//create new Random number generator
		Random random = new Random();

		//set long seed value using setter method
		Random random1 = new Random();
		random1.setSeed(1234567890);
		
		//generate random number integer
		int rand = random.nextInt();
		System.out.println(rand);
		
		//Generate Random number between 1 and 10
		rand = 0;
		while (true){
		    rand = random.nextInt(11);
		    if(rand !=0) break;
		}
		System.out.println(rand);
		
		//Generate random double
		double d = random.nextDouble();
		double d1 = Math.random();
		
		//Generate random float
		float f = random.nextFloat();

		//Generate random long
		long l = random.nextLong();

		//Generate random boolean
		boolean flag = random.nextBoolean();

		//Generate random number byte array
		byte[] randomByteArray = new byte[5];
		random.nextBytes(randomByteArray);
		System.out.println(Arrays.toString(randomByteArray));
		
		//SecureRandom example
		Random secureRandom = new SecureRandom();

		int srand = secureRandom.nextInt();

		System.out.println(srand);
	}

}
