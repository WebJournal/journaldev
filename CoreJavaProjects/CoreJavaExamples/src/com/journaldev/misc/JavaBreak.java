package com.journaldev.misc;

public class JavaBreak {

    public static void main(String[] args) {
        String[] arr = {"A", "E", "I", "O", "U"};
        
        //find O in the array using for loop
        for(int len=0; len < arr.length; len++){
            if(arr[len].equals("O")){
                System.out.println("Array contains 'O' at index: "+len);
                //break the loop as we found what we are looking for
                break;
            }
        }
        
        //use of break in while loop
        int len=0;
        while(len < arr.length){
            if(arr[len].equals("E")){
                System.out.println("Array contains 'E' at index: "+len);
                //break the while loop as we found what we are looking for
                break;
            }
            len++;
        }
        
        len = 0;
        //use of break in do-while loop
        do{
            if(arr[len].equals("U")){
                System.out.println("Array contains 'U' at index: "+len);
                //break the while loop as we found what we are looking for
                break;
            }
            len++;
        }while(len < arr.length);
    }

}
