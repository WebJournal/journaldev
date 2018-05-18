package com.journaldev.sorting;

import java.util.Arrays;

public class Insertion_Sort {
    
    public static void main(String args[]){
        
        int A [] = new int[10];
        populateArray(A);
        System.out.println("Before Sorting: ");
        printArray(A);
        int key;
        int index;
        for(int j=1 ; j < A.length; j++){
            
             key = A[j];
             System.out.println("Key value before sorting : "+key);
             index = j-1;
             System.out.println("index before sorting :" + index);
             
             while((index > -1) && A[index] > key){
                
                 
                 A[index+1] = A[index];
                 index = index-1;
             }
             
             A[index+1] = key;
        }
        
        System.out.println("\nAfter Sorting: ");
        printArray(A);
        
    }
    
    
    public static void printArray(int [] B){
        
        
        System.out.println(Arrays.toString(B));
    }

    public static int [] populateArray(int[] B){
        for(int i=0 ; i< B.length;i++){
            
            B[i] = (int) (Math.random()*100);
            
        }
        return null;
    }
}
