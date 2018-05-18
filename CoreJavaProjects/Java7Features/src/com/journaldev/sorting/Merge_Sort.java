package com.journaldev.sorting;

import java.util.Arrays;

public class Merge_Sort {
    
   public static void main(String args[]){
       int A [] = new int[5];
       
       populateArray(A);
       System.out.println("before Sorting: ");
       printArray(A);
       
       A = merge_sort(A);
       
       System.out.println("\n After Sorting: ");
       
       printArray(A);
       
       
       
       
       
   } 
   
   public static int[] merge_sort(int[]B){
       
       if(B.length <= 1){
           
           return B;
       }
       
       int midPoint = (B.length)/2;
       int left[] = new int[midPoint];
       int [] right;
       
       if(B.length%2==0){
           right = new int[midPoint];
           
       }else{
           right = new int[midPoint+1];
       }
       
       int [] resultArray = new int[B.length];
       
       for(int i=0;i<midPoint;i++){
           
           left[i] = B[i];
       }
       int x=0;
       for(int j =midPoint; j<B.length;j++){
           
           right[x] = B[j];
           x++;
       }
       left =merge_sort(left);
       right = merge_sort(right);
       
       resultArray = merge(left,right);
       
    return resultArray;
   }
    public static int[] merge(int [] left , int[] right){
        
        int lengthResult = left.length + right.length;
        int [] result = new int[lengthResult];
        int indexL=0;
        int indexR=0;
        int indexRes=0;
        
        while(indexL < left.length || indexR < right.length)
        {
            
            if(indexL < left.length && indexR < right.length)
            {
                if(left[indexL] <= right[indexR])
                {
                  result[indexRes] = left[indexL];
                  indexL++;
                  indexRes++;
                }else
                {
                   result[indexRes] = right[indexR];
                   indexR++;
                   indexRes++;
                    
                }
                
            }else if(indexL < left.length)
            {
                
                result[indexRes] = left[indexL];
                indexL++;
                indexRes++; 
            }else if(indexR < right.length)
            {
                
                result[indexRes] = right[indexR];
                indexR++;
                indexRes++;
            }
        }
        
        
        return result;
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
