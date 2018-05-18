package com.journaldev.array;


import java.util.Arrays;


public class ArrayExamples {

    /**
     * This class shows how to convert String to character array and then character array to String
     * 
     * @param args
     */
    public static void main(String[] args) {
        String str = "journaldev.com";
        char[] charArr = str.toCharArray();
        //print the char[] elements
        System.out.println("String converted to char array: " + Arrays.toString(charArr));
        //let's convert char[] to String now
        String str1 = new String(charArr);
        System.out.println("char array converted to String: " + str1);
        //let's see if str and str1 are equals or not
        System.out.println("str == str1? " + (str == str1));
        System.out.println("str.equals(str1)? " + (str.equals(str1)));
    }

}
