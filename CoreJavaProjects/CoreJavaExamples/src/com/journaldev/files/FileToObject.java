package com.journaldev.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileToObject {

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream("EmployeeObject.ser");
            ObjectInputStream ois = new ObjectInputStream(is);
            EmployeeObject emp = (EmployeeObject) ois.readObject();
            ois.close();
            is.close();
            System.out.println(emp.toString());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
