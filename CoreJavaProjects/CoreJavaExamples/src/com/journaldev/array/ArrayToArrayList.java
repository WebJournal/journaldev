package com.journaldev.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayToArrayList {

    /**
     * This class shows different methods to convert Array to ArrayList
     * 
     * @param args
     */
    public static void main(String[] args) {
        String[] strArr = {"1", "2", "3", "4"};
        List<String> strList = new ArrayList<String>();
        //return the list representation of array
        //any change in array elements will change the arrayList elements also
        strList = Arrays.asList(strArr);
        System.out.println("Original ArrayList from Arrays.asList()");
        for (String str : strList)
            System.out.print(" " + str);
        //change the array element and see the effect is propogated to list also.
        strArr[0] = "5";
        System.out.println("\nChange in array effect on ArrayList");
        for (String str : strList)
            System.out.print(" " + str);
        //below code will throw java.lang.UnsupportedOperationException because
        // Arrays.asList() returns a fixed-size list backed by the specified array.
        //strList.add("5");

        strList = new ArrayList<String>();

        Collections.addAll(strList, strArr);
        //change both the array and arraylist and check if they are independent?
        strList.add("5");
        strArr[0] = "1";
        System.out.println("\nArray to ArrayList using Collections.addAll()");
        for (String str : strList)
            System.out.print(" " + str);

    }

}
