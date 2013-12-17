package com.journaldev.files;

import java.io.File;

public class JavaFilePermissions {

    public static void main(String[] args) {
        File file = new File("/Users/pankaj/run.sh");
        //check file permissions for application user
        System.out.println("File is readable? "+file.canRead());
        System.out.println("File is writable? "+file.canWrite());
        System.out.println("File is executable? "+file.canExecute());
        //change file permissions for application user only
        file.setReadable(false);
        file.setWritable(false);
        file.setExecutable(false);
        //change file permissions for other users also
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, true);
    }

}
