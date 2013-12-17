package com.journaldev.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Scanner;

public class InputStreamToString {

	public static void main(String[] args) throws IOException {
//		System.out.println(readFileToStringUsingBufferedReader("/Users/pankaj/file.txt"));
//		System.out.println(readFileToStringUsingStringWriter("/Users/pankaj/file.txt"));
//		System.out.println(readFileToStringUsingScanner("/Users/pankaj/file.txt"));
		
//		Date start = new Date();
//		readFileToStringUsingBufferedReader("/Users/pankaj/BigFile.txt");
//		Date end = new Date();
//		System.out.println("Total time taken using BufferedReader = "+(end.getTime()-start.getTime()));

		Date start = new Date();
		readFileToStringUsingStringWriter("/Users/pankaj/BigFile.txt");
		Date end = new Date();
		System.out.println("Total time taken using StringWriter = "+(end.getTime()-start.getTime()));
		
//		Date start = new Date();
//		readFileToStringUsingScanner("/Users/pankaj/BigFile.txt");
//		Date end = new Date();
//		System.out.println("Total time taken using Scanner = "+(end.getTime()-start.getTime()));

	}
	/**
	 * reading file and converting InputStream to String using BufferedReader
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String readFileToStringUsingBufferedReader(String fileName) throws IOException{
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		StringBuilder inputSB = null;
		try{
		fileInputStream = new FileInputStream(fileName);
		bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
		inputSB = new StringBuilder();
		String line = bufferedReader.readLine();
        while(line != null){
        	inputSB.append(line);
            line = bufferedReader.readLine();
            if(line != null){
            	//add new line character
            	inputSB.append("\n");
            }
        }
		}finally{
			bufferedReader.close();
			fileInputStream.close();
		}
		return inputSB.toString();
	}

	/**
	 * reading file and converting InputStream to String using StringWriter
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String readFileToStringUsingStringWriter(String fileName) throws IOException{
		FileInputStream fileInputStream = null;
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
        try {
        	fileInputStream = new FileInputStream(fileName);
            Reader reader = new BufferedReader(
                    new InputStreamReader(fileInputStream, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        	writer.close();
        	fileInputStream.close();
        }
        return writer.toString();
	}
	
	/**
	 * reading file and converting InputStream to String using Scanner
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String readFileToStringUsingScanner(String fileName) throws IOException{
		FileInputStream fileInputStream = null;
		Scanner scanner = null;
		try{
		fileInputStream = new FileInputStream(fileName);
		scanner = new Scanner(fileInputStream,"UTF-8");
        return scanner.useDelimiter("\\A").next();
		}finally{
			fileInputStream.close();
			scanner.close();
		}

	}
}
