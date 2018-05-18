package com.journaldev.io.readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingBufferedReader {

	public static void main(String[] args) {
		BufferedReader reader;
		char[] buffer = new char[10];
		try {
			reader = new BufferedReader(new FileReader(
					"/Users/pankaj/Downloads/myfile.txt"));
			while (reader.read(buffer) != -1) {
				System.out.print(new String(buffer));
				buffer = new char[10];
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}