package com.journaldev.io.readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileUsingScanner {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("/Users/pankaj/Downloads/myfile.txt"));
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}