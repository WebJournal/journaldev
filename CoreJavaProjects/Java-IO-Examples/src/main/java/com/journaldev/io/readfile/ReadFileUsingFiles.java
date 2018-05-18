package com.journaldev.io.readfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileUsingFiles {

	public static void main(String[] args) {
		try {
			List<String> allLines = Files.readAllLines(Paths.get("/Users/pankaj/Downloads/myfile.txt"));
			for (String line : allLines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}