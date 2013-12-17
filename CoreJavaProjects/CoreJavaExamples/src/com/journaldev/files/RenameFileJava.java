package com.journaldev.files;

import java.io.File;

public class RenameFileJava {

    /**
     * Rename File in Java example
     * @param args
     */
    public static void main(String[] args) {
        //absolute path rename file
        File file = new File("/Users/pankaj/java.txt");
        File newFile = new File("/Users/pankaj/java1.txt");
        if(file.renameTo(newFile)){
            System.out.println("File rename success");;
        }else{
            System.out.println("File rename failed");
        }
        
        //relative path rename file
        file = new File("DB.properties");
        newFile = new File("DB_New.properties");
        if(file.renameTo(newFile)){
            System.out.println("File rename success");;
        }else{
            System.out.println("File rename failed");
        }
        
        //move file from one directory to another
        file = new File("/Users/pankaj/DB.properties");
        newFile = new File("DB_Move.properties");
        if(file.renameTo(newFile)){
            System.out.println("File move success");;
        }else{
            System.out.println("File move failed");
        }
        
        //when source file is not present
        file = new File("/Users/pankaj/xyz.txt");
        newFile = new File("xyz.properties");
        if(file.renameTo(newFile)){
            System.out.println("File move success");;
        }else{
            System.out.println("File move failed");
        }
        
        // when destination already have a file with same name
        file = new File("/Users/pankaj/export.sql");
        newFile = new File("/Users/pankaj/java1.txt");
        if(file.renameTo(newFile)){
            System.out.println("File move success");;
        }else{
            System.out.println("File move failed");
        }
    }

}
