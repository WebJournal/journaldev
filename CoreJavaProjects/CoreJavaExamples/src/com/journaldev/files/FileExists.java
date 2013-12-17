package com.journaldev.files;

import java.io.File;
import java.io.IOException;

public class FileExists {

    public static void main(String[] args) {
        File file = new File("/Users/pankaj/source.txt");
        File notExist = new File("xyz.txt");
        
        try {
            System.out.println(file.getCanonicalPath() + " exists? "+file.exists());
            System.out.println(notExist.getCanonicalPath() + " exists? "+notExist.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
