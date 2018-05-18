package com.journaldev.io.readfile;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileUsingFileInputStream {

	public static void main(String[] args) {
		FileInputStream fis;
		byte[] buffer = new byte[10];

		try {
			fis = new FileInputStream("/Users/pankaj/Downloads/myfile.txt");
			while (fis.read(buffer) != -1) {
				System.out.print(new String(buffer));
				buffer = new byte[10];
			}
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}