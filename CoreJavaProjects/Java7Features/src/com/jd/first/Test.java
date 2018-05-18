package com.jd.first;

import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //method(null);
    	Random random = new Random();
    	for(int i=0;i<10;i++){
    	    System.out.print(random.nextInt(10)+" ");
    	    Thread.sleep(1000);
    	}
    	
    }
    public static void method(Object o) {
        System.out.println("Object impl");
    }
    public static void method(String s) {
        System.out.println("String impl");
    }
}