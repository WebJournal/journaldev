package com.journaldev.files;

import java.io.File;

public class FileSize {

    /**
     * This class shows how to get file size in java
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("/Users/pankaj/Desktop/Security-Video.mov");
        if(file.exists()){
        System.out.println(getFileSizeBytes(file));
        System.out.println(getFileSizeKiloBytes(file));
        System.out.println(getFileSizeMegaBytes(file));
        }else System.out.println("File doesn't exist");
        
    }

    private static String getFileSizeMegaBytes(File file) {
        return (double) file.length()/(1024*1024)+" mb";
    }

    private static String getFileSizeKiloBytes(File file) {
        return (double) file.length()/1024+"  kb";
    }

    private static String getFileSizeBytes(File file) {
        return file.length()+" bytes";
    }

}
