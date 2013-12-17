package com.journaldev.files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaFileScanner {

    public static void main(String[] args) throws IOException {
        /**
         *  My Name is Pankaj
         *  My website is journaldev.com
         *  Phone : 1234567890
         */
        String fileName = "/Users/pankaj/source.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        
        //read file line by line
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            System.out.println("Lines: "+scanner.next());
        }
        scanner.close();
        //read CSV Files and parse it to object array
        /**
         * Pankaj,28,Male
         * Lisa,30,Female
         * Mike,25,Male
         */
        scanner = new Scanner(Paths.get("/Users/pankaj/data.csv"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            //parse line to get Emp Object
            Employee emp = parseCSVLine(scanner.next());
            System.out.println(emp.toString());
        }
        scanner.close();
        
        //read from system input
        System.out.println("Read from system input:");
        scanner = new Scanner(System.in);
        System.out.println("Input first word: "+scanner.next());
    }
    
    private static Employee parseCSVLine(String line) {
         Scanner scanner = new Scanner(line);
         scanner.useDelimiter("\\s*,\\s*");
         String name = scanner.next();
         int age = scanner.nextInt();
         String gender = scanner.next();
         JavaFileScanner jfs = new JavaFileScanner();
         return jfs.new Employee(name, age, gender);
    }

    public class Employee{
        private String name;
        private int age;
        private String gender;
        
        public Employee(String n, int a, String gen){
            this.name = n;
            this.age = a;
            this.gender = gen;
        }
        
        @Override
        public String toString(){
            return "Name="+this.name+"::Age="+this.age+"::Gender="+this.gender;
        }
    }

}
