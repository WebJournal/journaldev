package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file using FileWriter write(String  str) method
 * 
 * @author pankaj
 *
 */
public class FileWriterWriteString {

	public static void main(String[] args) {
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.Writer 
			fileWriter.write("JournalDev");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}