package com.journaldev.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResource {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			readFirstLineFromFileWithFinallyBlock("/Users/pankaj/Desktop/temp.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String readFirstLineFromFileWithFinallyBlock(String path) throws Exception {
		  BufferedReader br = new BufferedReader(new FileReader(path));
		  try {
		    System.out.println("before sleep.");
		    Thread.sleep(20000);
		    String str= br.readLine();
		    
		    System.out.println("after sleep"+str);
		    throw new Exception("My Excepton");
		  } finally {
		    if (br != null) br.close();
		  }
		}

}
