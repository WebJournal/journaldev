package com.journaldev.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String args[]) {
		int arr[] = { 5,4,3,2,1 };
		int arr1[] = { 1,2,3,4,5 };
		System.out.println("Array after sorting in ascending order:"+Arrays.toString(bubbleSortAscending(arr)));
		System.out.println("Array after sorting in descending order:"+Arrays.toString(bubbleSortDescending(arr1)));
	}
	
	public static int[] bubbleSortAscending(int[] arr){
		int temp;
		for(int i=0; i < arr.length-1; i++){
			
			for(int j=1; j < arr.length-i; j++){
				if(arr[j-1] > arr[j]){
					temp=arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			//check that last index has highest value in first loop,
			// second last index has second last highest value and so on
			System.out.println("Array after "+(i+1)+"th iteration:"+Arrays.toString(arr));
		}
		return arr;
	}
	
	public static int[] bubbleSortDescending(int[] arr){
		int temp;
		for(int i=0; i < arr.length-1; i++){
			
			for(int j=1; j < arr.length-i; j++){
				if(arr[j-1] < arr[j]){
					temp=arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			//check that last index has highest value in first loop,
			// second last index has second last highest value and so on
			System.out.println("Array after "+(i+1)+"th iteration:"+Arrays.toString(arr));
		}
		return arr;
	}

}
