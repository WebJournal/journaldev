package com.journaldev.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectToFile {

    public static void main(String[] args) {
        EmployeeObject emp = new EmployeeObject();
        
        emp.setAge(10);
        emp.setGender("Male");
        emp.setName("Pankaj");
        
        try {
            FileOutputStream fos = new FileOutputStream("EmployeeObject.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //write object to file
            oos.writeObject(emp);
            System.out.println("Done");
            //closing resources
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
