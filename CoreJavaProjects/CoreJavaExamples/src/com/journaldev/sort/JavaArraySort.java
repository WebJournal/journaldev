package com.journaldev.sort;

import java.util.Arrays;

public class JavaArraySort {

    /**
     * This class shows how to sort an array in Java
     * @param args
     */
    public static void main(String[] args) {
        int[] intArr = {1, 4, 2, 6, 3};
        String[] strArr = {"E", "A", "U","O","I"};
        //sort int array
        Arrays.sort(intArr);
        Arrays.sort(strArr);
        
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(strArr));
    }

}
