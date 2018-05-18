package com.journaldev.io.readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileJavaExample {

	/**
	 * Main function to invoke different functions to
	 * 1. readCompleteFileAsString - Read complete file as String
	 * 2. readFileToListOfLines - Read lines from file and return list of line String
	 * 3. countStringInFile - Count occurrence of a String in the file
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "/Users/pankaj/Downloads/myfile.txt";

		String str="Java";

		String fileData = readCompleteFileAsString(filePath);

		System.out.println("Complete File Data:"+fileData);

		List<String> linesData = readFileToListOfLines(filePath);

		if(linesData!=null){
			for(int i=0; i<linesData.size(); i++){
				System.out.println("Line "+i+": "+linesData.get(i));
			}
		}

		int count = countStringInFile(filePath,str);

		System.out.println("String "+str+" found "+count+" times in the given file");

	}

	/**
	 * This function will count the number of times given String appears in the file
	 * @param filePath
	 * @param string
	 * @return
	 */
	private static int countStringInFile(String filePath, String str) {
		if(filePath == null || filePath == "" || str == null || str == "") return 0;
		int count=0;
		int searchStrLength = str.length();
		BufferedReader reader;
		try {
			reader = new BufferedReader(
			        new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File is not present in the classpath or given location.");
			return 0;
		}
		String line;
		 try {
			while ((line=reader.readLine()) != null) {
				for(int i=0;i<line.length();) {
					int index=line.indexOf(str,i);
					if(index!=-1) {
						count++;
						i+=index+searchStrLength;
					} else {
						break;
					}
				}
			 }
		} catch (IOException e) {
			System.out.println("IOException in reading data from file.");
			return 0;
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("IOException in closing the Buffered Reader.");
			return count;
		}
		return count;
	}

	/**
	 * This function will read file line by line and return the data in form of list of String
	 * @param filePath
	 * @return
	 */
	private static List<String> readFileToListOfLines(String filePath) {
		List<String> linesData = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(
			        new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File is not present in the classpath or given location.");
			return null;
		}
		String line;
		 try {
			while ((line=reader.readLine()) != null) {
				 linesData.add(line);
			 }
		} catch (IOException e) {
			System.out.println("IOException in reading data from file.");
			return null;
		}
		try {
			reader.close();
		} catch (IOException e) {
			System.out.println("IOException in closing the Buffered Reader.");
			return null;
		}
		return linesData;
	}

	/**
	 * This function will read complete file and return it as String
	 * @param filePath
	 * @return
	 */
	private static String readCompleteFileAsString(String filePath) {

		StringBuilder fileData = new StringBuilder();
		BufferedReader reader;
		try {
			reader = new BufferedReader(
			        new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("File is not present in the classpath or given location.");
			return null;
		}
		char[] buf = new char[1024];
        int numRead=0;
        try {
			while((numRead=reader.read(buf)) != -1){
			    String readData = String.valueOf(buf, 0, numRead);
			    fileData.append(readData);
			    buf = new char[1024];
			}
		} catch (IOException e) {
			System.out.println("IOException in reading data from file.");
			return null;
		}
        try {
			reader.close();
		} catch (IOException e) {
			System.out.println("IOException in closing the Buffered Reader.");
			return null;
		}
		return fileData.toString();
	}

}