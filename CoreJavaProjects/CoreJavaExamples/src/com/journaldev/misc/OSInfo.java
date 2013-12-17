package com.journaldev.misc;

import java.util.Properties;
import java.util.Set;

public class OSInfo {

    public static void main(String[] args) {
        Properties prop = System.getProperties();
        Set<Object> keySet = prop.keySet();
        for(Object obj : keySet){
            System.out.println("System Property: {"+obj.toString()+","+System.getProperty(obj.toString())+"}");
        }
    }

}
