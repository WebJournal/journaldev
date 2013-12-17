package com.journaldev.array;

import java.util.Arrays;

public class ArrayToString {

    public static void main(String[] args) {
        
        ArrayToString arrayToString = new ArrayToString();
        A[] arr = {arrayToString.new A("1"), arrayToString.new A("2"), arrayToString.new A("3")};
        //default toString() method
        System.out.println(arr.toString());
        //using Arrays.toString() for printing object array contents
        System.out.println(Arrays.toString(arr));
        //converting Object Array to String
        System.out.println(convertObjectArrayToString(arr));
    }
    
    //custom class
    class A{
        private String name;
        public A(String name){
            this.name = name;
        }
        @Override
        public String toString(){
            System.out.println("A toString() method called!!");
            return this.name;
        }
    }
    
    //array to String implementation
    private static String convertObjectArrayToString(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for(Object obj : objArr) sb.append(obj.toString());
        return sb.toString();
    }

}
