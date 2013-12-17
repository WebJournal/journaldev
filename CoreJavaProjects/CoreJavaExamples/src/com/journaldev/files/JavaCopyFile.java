package com.journaldev.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

public class JavaCopyFile {

    public static void main(String[] args) throws InterruptedException, IOException {
        File source = new File("/Users/pankaj/tmp/source.avi");
        File dest = new File("/Users/pankaj/tmp/dest.avi");

        //copy file conventional way
        long start = System.nanoTime();
        copyFileUsingStream(source, dest);
        System.out.println("Time taken by Stream Copy = "+(System.nanoTime()-start));
        
        //copy files using java.nio
        source = new File("/Users/pankaj/tmp/sourceChannel.avi");
        dest = new File("/Users/pankaj/tmp/destChannel.avi");
        start = System.nanoTime();
        copyFileUsingChannel(source, dest);
        System.out.println("Time taken by Channel Copy = "+(System.nanoTime()-start));
        
        //copy files using apache commons io
        source = new File("/Users/pankaj/tmp/sourceApache.avi");
        dest = new File("/Users/pankaj/tmp/destApache.avi");
        start = System.nanoTime();
        copyFileUsingApacheCommonsIO(source, dest);
        System.out.println("Time taken by Apache Commons IO Copy = "+(System.nanoTime()-start));
        
        //using Java 7 Files class
        source = new File("/Users/pankaj/tmp/sourceJava7.avi");
        dest = new File("/Users/pankaj/tmp/destJava7.avi");
        start = System.nanoTime();
        copyFileUsingJava7Files(source, dest);
        System.out.println("Time taken by Java7 Files Copy = "+(System.nanoTime()-start));
        
//        //using Runtime.exec
//        source = new File("/Users/pankaj/tmp/sourceRuntime.avi");
//        dest = new File("/Users/pankaj/tmp/destRuntime.avi");
//        start = System.nanoTime();
//        copyFileUsingJavaRuntime(source, dest);
//        System.out.println("Time taken by Java Runtime.exec Copy = "+(System.nanoTime()-start));
        
    }


    private static void copyFileUsingJavaRuntime(File source, File dest) throws IOException, InterruptedException {
        String cmd = "cp "+source.getCanonicalPath()+ " "+dest.getCanonicalPath();
        Process process = Runtime.getRuntime().exec(cmd);
        //we need to wait till process get's finished using waitFor()
        System.out.println("File Copy status: "+process.waitFor());
    }


    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }


    private static void copyFileUsingApacheCommonsIO(File source, File dest) throws IOException {
        FileUtils.copyFile(source, dest);
    }


    private static void copyFileUsingChannel(File source, File dest) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
           }finally{
               sourceChannel.close();
               destChannel.close();
           }
    }


    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

}
