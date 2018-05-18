package com.journaldev.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaListSort {

    /**
     * This class shows how to sort ArrayList in java
     * @param args
     */
    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        //using Collections.sort() to sort ArrayList
        Collections.sort(strList);
        for(String str: strList) System.out.print(" "+str);
        
    }

}
