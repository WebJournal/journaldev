package com.journaldev.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class shows how to create ArrayList of arrays of same type and different types
 * @author pankaj
 *
 */
public class ArrayListOfArrays {

    public static void main(String[] args) {

        arrayListOfString();

        arrayListOfObjects();

    }


    /**
     * This method shows how to create ArrayList of Arrays of same type
     */
    private static void arrayListOfString() {
        //List of String arrays
        List<String[]> list = new ArrayList<String[]>();
        String[] arr1 = {"a", "b", "c"};
        String[] arr2 = {"1", "2", "3", "4"};
        list.add(arr1);
        list.add(arr2);
        //printing list of String arrays in the ArrayList
        for (String[] strArr : list) {
            System.out.println(Arrays.toString(strArr));
        }
    }


    /**
     * This method shows how to create ArrayList of Arrays of different types
     */
    private static void arrayListOfObjects() {
        //list of Object arrays to hold different types of array
        List<Object[]> list = new ArrayList<Object[]>();
        String[] arr1 = {"a", "b", "c"};
        String[] arr2 = {"1", "2", "3", "4"};
        ArrayListOfArrays aa = new ArrayListOfArrays();
        ArrayListOfArrays.A[] arr3 = {aa.new A("AA"), aa.new A("BB")};
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        //list holds different types of Object arrays, let's print them
        for (Object[] objArr : list) {
            System.out.println(Arrays.toString(objArr));
            //iterating over the array and doing operation based on it's type
            for (Object obj : objArr) {
                //using instanceof keyword to find the Object type in the array
                if (obj instanceof String) {
                    //doSomethingForStringObject();
                } else if (obj instanceof ArrayListOfArrays.A) {
                    //doSomethingForAObject();
                }
            }
        }
    }


    /**
     * A sample class to use in arraylist of arrays
     * 
     * @author pankaj
     * 
     */
    public class A {
        private String name;


        public A(String n) {
            this.name = n;
        }


        public String getName() {
            return this.name;
        }


        @Override
        public String toString() {
            return this.name;
        }
    }

}
