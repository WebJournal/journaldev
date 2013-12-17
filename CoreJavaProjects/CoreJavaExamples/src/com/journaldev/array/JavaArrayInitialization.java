package com.journaldev.array;

public class JavaArrayInitialization {

    /**
     * This class shows how to initialize array of
     * different types with new operator and shortcut syntax
     * @param args
     */
    public static void main(String[] args) {
        //initialize primitive one dimensional array
        int[] arrInt = new int[5];
        System.out.println(arrInt[2]);
        //initialize Object one dimensional array
        String[] strArr;
        strArr = new String[4];
        System.out.println(strArr[2]);
        //initialize multidimensional array
        int[] twoArrInt[] = new int[4][5];
        //multidimensional array initialization with only leftmost dimension
        int twoIntArr[][] = new int[5][];
        //array initialization using shortcut syntax
        int[] arrI = {1,2,3};
        int[][] arrI2 = {{1,2}, {1,2,3}};
        //length of array is number of rows or the left most dimension of array
        int i = arrI2.length;
        
    }

}
