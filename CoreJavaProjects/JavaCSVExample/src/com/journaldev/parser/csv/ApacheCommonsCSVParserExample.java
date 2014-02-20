package com.journaldev.parser.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class ApacheCommonsCSVParserExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//Create the CSVFormat object
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
		
		//initialize the CSVParser object
		CSVParser parser = new CSVParser(new FileReader("employees.csv"), format);
		
		List<Employee> emps = new ArrayList<Employee>();
		for(CSVRecord record : parser){
			Employee emp = new Employee();
			emp.setId(record.get("ID"));
			emp.setName(record.get("Name"));
			emp.setRole(record.get("Role"));
			emp.setSalary(record.get("Salary"));
			emps.add(emp);
		}
		//close the parser
		parser.close();
		
		System.out.println(emps);
		
		//CSV Write Example using CSVPrinter
		CSVPrinter printer = new CSVPrinter(System.out, format.withDelimiter('#'));
		System.out.println("********");
		printer.printRecord("ID","Name","Role","Salary");
		for(Employee emp : emps){
			List<String> empData = new ArrayList<String>();
			empData.add(emp.getId());
			empData.add(emp.getName());
			empData.add(emp.getRole());
			empData.add(emp.getSalary());
			printer.printRecord(empData);
		}
		//close the printer
		printer.close();
	}

}
