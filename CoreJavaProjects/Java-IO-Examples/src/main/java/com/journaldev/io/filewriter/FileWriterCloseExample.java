package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file with FileWriter close() method
 * 
 * @author pankaj
 *
 */
public class FileWriterCloseExample {

	public static void main(String[] args) {
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.Writer 
			fileWriter.write("JournalDev");
			//inherited method from java.io.OutputStreamWriter
			fileWriter.close();;
			
			fileWriter.write(" Tutorials");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}