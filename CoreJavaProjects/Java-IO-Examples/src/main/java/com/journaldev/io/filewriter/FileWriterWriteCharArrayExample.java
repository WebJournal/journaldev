package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file using FileWriter write(char[] cbuf) method
 * 
 * @author pankaj
 *
 */
public class FileWriterWriteCharArrayExample {

	public static void main(String[] args) {
		char[] data = "This is FileWriter Example.".toCharArray();
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.Writer 
			fileWriter.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}