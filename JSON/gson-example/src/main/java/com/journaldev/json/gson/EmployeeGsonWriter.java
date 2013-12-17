package com.journaldev.json.gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Set;

import com.google.gson.stream.JsonWriter;
import com.journaldev.json.model.Employee;

public class EmployeeGsonWriter {

	public static void main(String[] args) throws IOException {
		Employee emp = EmployeeGsonExample.createEmployee();
		
		//writing on console, we can initialize with FileOutputStream to write to file
		OutputStreamWriter out = new OutputStreamWriter(System.out);
		JsonWriter writer = new JsonWriter(out);
		//set indentation for pretty print
		writer.setIndent("\t");
		//start writing
		writer.beginObject(); //{
		writer.name("id").value(emp.getId()); // "id": 123
		writer.name("name").value(emp.getName()); // "name": "David"
		writer.name("permanent").value(emp.isPermanent()); // "permanent": false
		writer.name("address").beginObject(); // "address": {
			writer.name("street").value(emp.getAddress().getStreet()); // "street": "BTM 1st Stage"
			writer.name("city").value(emp.getAddress().getCity()); // "city": "Bangalore"
			writer.name("zipcode").value(emp.getAddress().getZipcode()); // "zipcode": 560100
			writer.endObject(); // }
		writer.name("phoneNumbers").beginArray(); // "phoneNumbers": [
			for(long num : emp.getPhoneNumbers()) writer.value(num); //123456,987654
			writer.endArray(); // ]
		writer.name("role").value(emp.getRole()); // "role": "Manager"
		writer.name("cities").beginArray(); // "cities": [
			for(String c : emp.getCities()) writer.value(c); //"Los Angeles","New York"
			writer.endArray(); // ]
		writer.name("properties").beginObject(); //"properties": {
			Set<String> keySet = emp.getProperties().keySet();
			for(String key : keySet) writer.name("key").value(emp.getProperties().get(key));//"age": "28 years","salary": "1000 Rs"
			writer.endObject(); // }
		writer.endObject(); // }
		
		writer.flush();
		
		//close writer
		writer.close();
		
	}

}
