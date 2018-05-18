package com.journaldev.string;

import java.util.Arrays;

public class StringArrayToString {

    /**
     * This program shows how to convert String Array to String
     * @param args
     */
    public static void main(String[] args) {
        String[] strArr = {"1","2","3"};
        //using array toString() method
        System.out.println(strArr.toString());
        //using Arrays.toString() method to print String array contents
        System.out.println(Arrays.toString(strArr));
        //converting String array to String by appending them
        System.out.println(convertStringArrayToString(strArr));
    }

    private static String convertStringArrayToString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for(String str : strArr) sb.append(str);
        return sb.toString();
    }

}
