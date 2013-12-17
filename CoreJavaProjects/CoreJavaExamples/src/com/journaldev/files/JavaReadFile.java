package com.journaldev.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class JavaReadFile {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/pankaj/source.txt";
        
        //using Java 7 Files class to process small files, get complete file data
        readUsingFiles(fileName);
        
        //using Scanner class for large files, to read line by line
        readUsingScanner(fileName);
        
        //read using BufferedReader, to read line by line
        readUsingBufferedReader(fileName);
        readUsingBufferedReaderJava7(fileName, StandardCharsets.UTF_8);
        readUsingBufferedReader(fileName, StandardCharsets.UTF_8);
        
        //read using FileReader, no encoding support, not efficient
        readUsingFileReader(fileName);
    }

    private static void readUsingFileReader(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        }
        br.close();
        fr.close();
        
    }

    private static void readUsingBufferedReader(String fileName, Charset cs) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, cs);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        }
        br.close();
        
    }

    private static void readUsingBufferedReaderJava7(String fileName, Charset cs) throws IOException {
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path, cs);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        }
        br.close();
    }

    private static void readUsingBufferedReader(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            //process the line
            System.out.println(line);
        }
        //close resources
        br.close();
        fr.close();
    }

    private static void readUsingScanner(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        //read line by line
        while(scanner.hasNextLine()){
            //process each line
            String line = scanner.nextLine();
        }
    }

    private static void readUsingFiles(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        //read file to byte array
        byte[] bytes = Files.readAllBytes(path);
        //read file to String list
        List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
    }

}
