package com.journaldev.files;

import java.io.File;

public class CheckDirectoryOrFile {

    public static void main(String[] args) {
        File file = new File("/Users/pankaj/source.txt");
        File dir = new File("/Users/pankaj");
        File notExists = new File("/Users/pankaj/notafile");
        
        System.out.println("/Users/pankaj/source.txt is file?"+file.isFile());
        System.out.println("/Users/pankaj/source.txt is directory?"+file.isDirectory());
        
        System.out.println("/Users/pankaj is file?"+dir.isFile());
        System.out.println("/Users/pankaj is directory?"+dir.isDirectory());
        
        System.out.println("/Users/pankaj/notafile is file?"+notExists.isFile());
        System.out.println("/Users/pankaj/notafile is directory?"+notExists.isDirectory());
    }

}
