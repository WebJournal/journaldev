package com.journaldev.files;

import java.io.File;

public class DeleteFileJava {

    /**
     * This class shows how to delete a File in Java
     * @param args
     */
    public static void main(String[] args) {
        //absolute file name with path
        File file = new File("/Users/pankaj/file.txt");
        if(file.delete()){
            System.out.println("/Users/pankaj/file.txt File deleted");
        }else System.out.println("File /Users/pankaj/file.txt doesn't exists");
        
        //file name only
        file = new File("file.txt");
        if(file.delete()){
            System.out.println("file.txt File deleted from Project root directory");
        }else System.out.println("File file.txt doesn't exists in project root directory");
        
        //relative path
        file = new File("tmp/file.txt");
        if(file.delete()){
            System.out.println("tmp/file.txt File deleted from Project root directory");
        }else System.out.println("File tmp/file.txt doesn't exists in project root directory");
        
        //delete empty directory
        file = new File("tmp");
        if(file.delete()){
            System.out.println("tmp directory deleted from Project root directory");
        }else System.out.println("tmp directory doesn't exists or not empty in project root directory");
        
        //try to delete directory with files
        file = new File("/Users/pankaj/project");
        if(file.delete()){
            System.out.println("/Users/pankaj/project directory deleted from Project root directory");
        }else System.out.println("/Users/pankaj/project directory doesn't exists or not empty");
    }

}
