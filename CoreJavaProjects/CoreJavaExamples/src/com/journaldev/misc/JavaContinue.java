package com.journaldev.misc;

import java.util.Arrays;


public class JavaContinue {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "2", "1"};

        processArray(arr, "2");
        
        int[][] intArr = {{1,-2,3} , {0,3} , {1,2,5} , {9,2,5}};
        
        processIfAllPositive(intArr);
    }


    private static void processIfAllPositive(int[][] intArr) {
        process:
        for(int i=0; i < intArr.length;i++){
            boolean allPositive= true;
            for(int j=0; j < intArr[i].length;j++){
               if(intArr[i][j] < 0){
                   allPositive = false;
                   continue process;
               }
            }
            if(allPositive){
                //process the array
                System.out.println("Processing the array of all positive ints. "+Arrays.toString(intArr[i]));
            }
            allPositive=true;
        }
    }


    private static void processArray(String[] arr, String str) {
        for (String s : arr) {
            if (s.equals(str))
                continue;
            System.out.println("Processing " + s);
        }
    }

}
