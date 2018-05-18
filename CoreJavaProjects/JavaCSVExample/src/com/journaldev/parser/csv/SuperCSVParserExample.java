package com.journaldev.parser.csv;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class SuperCSVParserExample {

	public static void main(String[] args) throws IOException {

		List<Employee> emps = readCSVToBean();
		System.out.println(emps);
		System.out.println("******");
		writeCSVData(emps);
	}

	private static void writeCSVData(List<Employee> emps) throws IOException {
		ICsvBeanWriter beanWriter = null;
		StringWriter writer = new StringWriter();
		try{
			beanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
			final String[] header = new String[]{"id","name","role","salary"};
			final CellProcessor[] processors = getProcessors();
            
			// write the header
            beanWriter.writeHeader(header);
            
            //write the beans data
            for(Employee emp : emps){
            	beanWriter.write(emp, header, processors);
            }
		}finally{
			if( beanWriter != null ) {
                beanWriter.close();
			}
		}
		System.out.println("CSV Data\n"+writer.toString());
	}

	private static List<Employee> readCSVToBean() throws IOException {
		ICsvBeanReader beanReader = null;
		List<Employee> emps = new ArrayList<Employee>();
		try {
			beanReader = new CsvBeanReader(new FileReader("employees.csv"),
					CsvPreference.STANDARD_PREFERENCE);

			// the name mapping provide the basis for bean setters 
			final String[] nameMapping = new String[]{"id","name","role","salary"};
			//just read the header, so that it don't get mapped to Employee object
			final String[] header = beanReader.getHeader(true);
			final CellProcessor[] processors = getProcessors();

			Employee emp;
			
			while ((emp = beanReader.read(Employee.class, nameMapping,
					processors)) != null) {
				emps.add(emp);
			}

		} finally {
			if (beanReader != null) {
				beanReader.close();
			}
		}
		return emps;
	}

	private static CellProcessor[] getProcessors() {
		
		final CellProcessor[] processors = new CellProcessor[] { 
                new UniqueHashCode(), // ID (must be unique)
                new NotNull(), // Name
                new Optional(), // Role
                new NotNull() // Salary
        };
		return processors;
	}

}
