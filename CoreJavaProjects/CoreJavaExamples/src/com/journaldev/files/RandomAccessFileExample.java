package com.journaldev.files;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

    public static void main(String[] args) {
        try {
            String filePath = "/Users/pankaj/source.txt";
            System.out.println(new String(readCharsFromFile(filePath, 1, 5)));
            
            writeData(filePath, "Data", 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(String filePath, String data, int seek) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(seek);
        file.write(data.getBytes());
        file.close();
    }

    private static byte[] readCharsFromFile(String filePath, int seek, int chars) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        file.seek(seek);
        byte[] bytes = new byte[chars];
        file.read(bytes);
        file.close();
        return bytes;
    }

}
