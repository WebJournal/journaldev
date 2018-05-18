package com.journaldev.files;

import java.io.File;
import java.util.Date;

public class FileDate {

    public static void main(String[] args) {
        File file = new File("employee1.xml");
        
        long timestamp = file.lastModified();
        System.out.println("employee.xml last modified date = "+new Date(timestamp));
    }

}
