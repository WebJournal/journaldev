package com.journaldev.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

	/**
	 * This class will read file contents line by line
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("/Users/pankaj/file.txt");
			//create FileReader object from File object
			FileReader fr = new FileReader(file);
			//create BufferedReader object from FileReader to read file line by line
			BufferedReader reader = new BufferedReader(fr);
			//read first line to start
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				//read next line
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
