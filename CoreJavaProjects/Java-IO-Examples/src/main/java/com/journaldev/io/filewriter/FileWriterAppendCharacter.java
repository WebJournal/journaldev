package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file using FileWriter append(char c) method
 * 
 * @author pankaj
 *
 */
public class FileWriterAppendCharacter {

	public static void main(String[] args) {
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.Writer 
			fileWriter.write("JournalDev");
			fileWriter.append('C');
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}