package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file using FileWriter write(String  s,  int  off,  int  len) method
 * 
 * @author pankaj
 *
 */
public class FileWriterWriteStringExample {

	public static void main(String[] args) {
		String data = "This is FileWriter Example.";
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.OutputStreamWriter 
			fileWriter.write(data, 8, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}