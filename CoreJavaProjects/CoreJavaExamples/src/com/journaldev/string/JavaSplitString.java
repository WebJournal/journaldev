package com.journaldev.string;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaSplitString {

    /**
     * This program shows how to split a string in java
     * @param args
     */
    public static void main(String[] args) {
        String line = "I am a java developer";
        String[] words = line.split(" ");
        String[] twoWords = line.split(" ", 2);
        System.out.println("String split with delimiter: "+Arrays.toString(words));
        System.out.println("String split into two: "+Arrays.toString(twoWords));
        //split string delimited with special characters
        String wordsWithNumbers = "I|am|a|java|developer";
        String[] numbers = wordsWithNumbers.split("\\|");
        AtomicInteger ai = new AtomicInteger(5);
        System.out.println("String split with special character: "+Arrays.toString(numbers));
    }

}
