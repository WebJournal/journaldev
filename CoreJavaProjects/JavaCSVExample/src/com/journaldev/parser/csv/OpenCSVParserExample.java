package com.journaldev.parser.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class OpenCSVParserExample {

	public static void main(String[] args) throws IOException {

		List<Employee> emps = parseCSVFileLineByLine();
		System.out.println("**********");
		parseCSVFileAsList();
		System.out.println("**********");
		parseCSVToBeanList();
		System.out.println("**********");
		writeCSVData(emps);
	}

	private static void parseCSVToBeanList() throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<Employee> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<Employee>();
		beanStrategy.setType(Employee.class);
		
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put("ID", "id");
		columnMapping.put("Name", "name");
		columnMapping.put("Role", "role");
		//columnMapping.put("Salary", "salary");
		
		beanStrategy.setColumnMapping(columnMapping);
		
		CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
		CSVReader reader = new CSVReader(new FileReader("employees.csv"));
		List<Employee> emps = csvToBean.parse(beanStrategy, reader);
		System.out.println(emps);
	}

	private static void writeCSVData(List<Employee> emps) throws IOException {
		StringWriter writer = new StringWriter();
		CSVWriter csvWriter = new CSVWriter(writer,'#');
		List<String[]> data  = toStringArray(emps);
		csvWriter.writeAll(data);
		csvWriter.close();
		System.out.println(writer);
	}

	private static List<String[]> toStringArray(List<Employee> emps) {
		List<String[]> records = new ArrayList<String[]>();
		//add header record
		records.add(new String[]{"ID","Name","Role","Salary"});
		Iterator<Employee> it = emps.iterator();
		while(it.hasNext()){
			Employee emp = it.next();
			records.add(new String[]{emp.getId(),emp.getName(),emp.getRole(),emp.getSalary()});
		}
		return records;
	}

	private static List<Employee> parseCSVFileLineByLine() throws IOException {
		//create CSVReader object
		CSVReader reader = new CSVReader(new FileReader("employees.csv"), ',');
		
		List<Employee> emps = new ArrayList<Employee>();
		//read line by line
		String[] record = null;
		//skip header row
		reader.readNext();
		
		while((record = reader.readNext()) != null){
			Employee emp = new Employee();
			emp.setId(record[0]);
			emp.setName(record[1]);
			emp.setRole(record[2]);
			emp.setSalary(record[3]);
			emps.add(emp);
		}
		
		reader.close();
		
		System.out.println(emps);
		return emps;
	}
	
	private static void parseCSVFileAsList() throws IOException {
		//create CSVReader object
		CSVReader reader = new CSVReader(new FileReader("employees.csv"), ',');

		List<Employee> emps = new ArrayList<Employee>();
		//read all lines at once
		List<String[]> records = reader.readAll();
		
		Iterator<String[]> iterator = records.iterator();
		//skip header row
		iterator.next();
		
		while(iterator.hasNext()){
			String[] record = iterator.next();
			Employee emp = new Employee();
			emp.setId(record[0]);
			emp.setName(record[1]);
			emp.setRole(record[2]);
			emp.setSalary(record[3]);
			emps.add(emp);
		}
		
		reader.close();
		
		System.out.println(emps);
	}

}
