package com.journaldev.json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import com.journaldev.model.Employee;

public class EmployeeJSONGenerator {

	public static void main(String[] args) throws IOException {
		OutputStream fos = new FileOutputStream("emp_stream.txt");
		JsonGenerator jsonGenerator = Json.createGenerator(fos);
		/**
		 * We can get JsonGenerator from Factory class also
		 * JsonGeneratorFactory factory = Json.createGeneratorFactory(null);
		 * jsonGenerator = factory.createGenerator(fos);
		 */
		
		Employee emp = EmployeeJSONWriter.createEmployee();
		jsonGenerator.writeStartObject(); // {
		jsonGenerator.write("id", emp.getId()); // "id":123
		jsonGenerator.write("name", emp.getName());
		jsonGenerator.write("role", emp.getRole());
		jsonGenerator.write("permanent", emp.isPermanent());
		
		jsonGenerator.writeStartObject("address") //start of address object
			.write("street", emp.getAddress().getStreet())
			.write("city",emp.getAddress().getCity())
			.write("zipcode",emp.getAddress().getZipcode())
			.writeEnd(); //end of address object
		
		jsonGenerator.writeStartArray("phoneNumbers"); //start of phone num array
		for(long num : emp.getPhoneNumbers()){
			jsonGenerator.write(num);
		}
		jsonGenerator.writeEnd(); // end of phone num array
		jsonGenerator.writeEnd(); // }
		
		jsonGenerator.close();
		
	}

}
