package com.journaldev.io.filewriter;

import java.io.FileWriter;

/**
 * Java write file using FileWriter write method using try with resource
 * 
 * @author pankaj
 *
 */
public class FileWriterWriteIntTryWithResource {

	public static void main(String[] args) {
		try(FileWriter fileWriter = new FileWriter("D:/data/file.txt")) {
			//inherited method from java.io.OutputStreamWriter 
			fileWriter.write(65);
			fileWriter.write(66);
			fileWriter.write(67);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}