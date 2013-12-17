package com.journaldev.array;

import java.util.Arrays;

public class JavaArrayCopyExample {

    /**
     * This class shows different methods for copy array in java
     * @param args
     */
    public static void main(String[] args) {
        int[] source = {1,2,3,4,5,6,7,8,9};
        int[] source1 = {1,2,3};
        int[] destination=null;
        System.out.println("Source array = "+Arrays.toString(source));
        
        destination = copyFirstFiveFieldsOfArrayUsingSystem(source);
        System.out.println("Copy First five elements of array if available. Result array = "+Arrays.toString(destination));
        
        destination = copyFirstFiveFieldsOfArrayUsingSystem(source1);
        System.out.println("Copy First five elements of array if available. Result array = "+Arrays.toString(destination));
        
        destination = copyFullArrayUsingSystem(source);
        System.out.println("Copy full array using System.copyarray() function. Result array = "+Arrays.toString(destination));
        
        destination = copyFullArrayUsingClone(source);
        System.out.println("Copy full array using clone() function. Result array = "+Arrays.toString(destination));
        
        destination = copyFullArrayUsingArrayCopyOf(source);
        System.out.println("Copy full array using Arrays.copyOf() function. Result array = "+Arrays.toString(destination));
        
        destination = copyLastThreeUsingArrayCopyOfRange(source);
        System.out.println("Copy last three elements using Arrays.copyOfRange() function. Result array = "+Arrays.toString(destination));
    }

    /**
     * This method copy full array using Arrays.copyOf() function
     * @param source
     * @return
     */
    private static int[] copyFullArrayUsingArrayCopyOf(int[] source) {
        return Arrays.copyOf(source, source.length);
    }
    
    /**
     * This method copy partial array (last 3 elements) using 
     * Arrays.copyOfRange() function
     * @param source
     * @return
     */
    private static int[] copyLastThreeUsingArrayCopyOfRange(int[] source) {
        //length check is necessary to avoid java.lang.ArrayIndexOutOfBoundsException
        //but for simplicity I am not doing that
        return Arrays.copyOfRange(source, source.length-3, source.length);
    }

    /**
     * This method copy full array using clone() function
     * @param source
     * @return
     */
    private static int[] copyFullArrayUsingClone(int[] source) {
        return source.clone();
    }

    /**
     * This method copy full array using System.arraycopy() function
     * @param source
     * @return
     */
    private static int[] copyFullArrayUsingSystem(int[] source) {
        int[] temp=new int[source.length];
        System.arraycopy(source, 0, temp, 0, source.length);
        return temp;
    }

    /**
     * This method copy full first five elements of array 
     * using System.arraycopy() function
     * @param source
     * @return
     */
    private static int[] copyFirstFiveFieldsOfArrayUsingSystem(int[] source) {
        if(source.length > 5){
            int[] temp=new int[5];
            System.arraycopy(source, 0, temp, 0, 5);
            return temp;
        }else{
            int[] temp=new int[source.length];
            System.arraycopy(source, 0, temp, 0, source.length);
            return temp;
        }
        
    }

}
