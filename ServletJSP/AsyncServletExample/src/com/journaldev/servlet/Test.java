package com.journaldev.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test {

	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String encodedStr = URLEncoder.encode("Pankaj's Data", "utf-8");
		
		System.out.println(encodedStr);
		String decodedStr= URLDecoder.decode(encodedStr, "utf-8");
		
		System.out.println(decodedStr);
	}

}
