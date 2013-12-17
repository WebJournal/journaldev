package com.journaldev.string;

import java.util.Arrays;

public class StringToCharToString {

    /**
     * This class show how to convert String to char to String in java
     * @param args
     */
    public static void main(String[] args) {
        //String to char array
        String str = "123";
        char[] chArr = str.toCharArray();
        System.out.println("String to char array: "+Arrays.toString(chArr));
        //String to char
        char c = str.charAt(1);
        System.out.println("String to char: "+c);
        //char to String
        String s = Character.toString(c);
        System.out.println("char to String: "+s);
        //remove all given char from String
        System.out.println("removing all chars from String: "+removeCharFromString("1ABCD12DW", '1'));
    }

    private static String removeCharFromString(String str, char c) {
        return str.replaceAll(Character.toString(c), "");
    }

}
