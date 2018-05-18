package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file with FileWriter flush() method
 * 
 * @author pankaj
 *
 */
public class FileWriterFlushExample {

	public static void main(String[] args) {
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.Writer 
			fileWriter.write("JournalDev");
			//inherited method from java.io.OutputStreamWriter
			fileWriter.flush();
			
			fileWriter.write(" Tutorials");
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}