package com.journaldev.io.readfile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadFileUsingRandomAccessFile {

	public static void main(String[] args) {
		try {
			RandomAccessFile file = new RandomAccessFile("/Users/pankaj/Downloads/myfile.txt", "r");
			String str;
			while ((str = file.readLine()) != null) {
				System.out.println(str);
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}