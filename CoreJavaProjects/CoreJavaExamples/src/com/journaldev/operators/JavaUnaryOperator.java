package com.journaldev.operators;

public class JavaUnaryOperator {

    public static void main(String[] args) {
        //Using java 7 binary representation for easy understanding
        
        int i = 0b01111;
        int inverted = -0b10000;
        System.out.println("i="+i);
        System.out.println("inverted="+inverted);
        int y = ~i;
        System.out.println("y="+y);
    }

}
