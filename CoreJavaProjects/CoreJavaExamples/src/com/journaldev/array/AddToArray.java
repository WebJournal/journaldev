package com.journaldev.array;

import java.util.Arrays;

public class AddToArray {

    public static void main(String[] args) {
        Object[] objArr1 = {"1","2","3"};
        Object[] objArr2 = {"4","5","6"};
        //adding an element to array
        Object[] objArr = add(objArr1, "4");
        System.out.println(Arrays.toString(objArr));
        //adding two arrays
        objArr = add(objArr1, objArr2);
        System.out.println(Arrays.toString(objArr));
        
    }
    
    /**
     * This method will add elements to an array and return the resulting array
     * @param arr
     * @param elements
     * @return
     */
    public static Object[] add(Object[] arr, Object... elements){
        Object[] tempArr = new Object[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        
        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;
        
    }
    

}
