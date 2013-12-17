package com.journaldev.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class ReadFileToString {

    /**
     * This class shows different ways to read
     * complete file contents to String
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/pankaj/source.txt";
        
        String contents = readUsingScanner(fileName);
        
        contents = readUsingApacheCommonsIO(fileName);
        
        contents = readUsingFiles(fileName);
        
        contents = readUsingBufferedReader(fileName);
        System.out.println(contents);
        System.out.println(contents.length());
    }

    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader (fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }
        //delete the last ls
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static String readUsingApacheCommonsIO(String fileName) throws IOException {
        return FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
    }

    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        //we can use Delimiter regex as "\\A", "\\Z" or "\\z"
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }

}
