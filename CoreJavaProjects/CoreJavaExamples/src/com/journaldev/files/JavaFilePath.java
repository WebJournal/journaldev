package com.journaldev.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JavaFilePath {

    public static void main(String[] args) throws IOException, URISyntaxException {
        File file = new File("/Users/pankaj/test.txt");
        printPaths(file);
        //relative path
        file = new File("test.xsd");
        printPaths(file);
        //complex relative paths
        file =new File("/Users/pankaj/../pankaj/test.txt");
        printPaths(file);
        //URI paths
        file =new File(new URI("file:///Users/pankaj/test.txt"));
        printPaths(file);
    }

    private static void printPaths(File file) throws IOException {
        System.out.println("Absolute Path: "+file.getAbsolutePath());
        System.out.println("Canonical Path: "+file.getCanonicalPath());
        System.out.println("Path: "+file.getPath());
    }

}
