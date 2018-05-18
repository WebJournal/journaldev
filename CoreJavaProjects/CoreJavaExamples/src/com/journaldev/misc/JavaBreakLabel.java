package com.journaldev.misc;


public class JavaBreakLabel {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {9, 10}, {11, 12}};
        boolean found = false;
        int row = 0;
        int col = 0;
        //find index of first int greater than 10
        searchint:

        for (row=0; row < arr.length; row++) {
            for (col=0; col < arr[row].length; col++) {
                if (arr[row][col] > 10) {
                    found = true;
                    //using break label to terminate outer statements
                    break searchint;
                }
            }
        }
        if (found)
            System.out.println("First int greater than 10 is found at index: [" + row + "," + col +
                    "]");
    }

}
