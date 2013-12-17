package com.journaldev.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

public class TestException1 {

	public static void main(String[] args) {
			try {
				go();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
	}

	public static void go() throws IOException, JAXBException, FileNotFoundException{
		
	}
}
