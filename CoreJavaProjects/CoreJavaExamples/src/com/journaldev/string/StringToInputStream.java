package com.journaldev.string;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class StringToInputStream {

    /**
     * This program shows how to convert String to InputStream
     * and then print it to console
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String str = "Convert this String to InputStream";
        //convert String to InputStream using ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));
        // lets print it to console
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        while(line !=null){
            System.out.println(line);
            line = br.readLine();
        }
    }

}
