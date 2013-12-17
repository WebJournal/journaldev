package com.journaldev.jackson.json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.journaldev.jackson.model.Employee;

public class JacksonStreamingWriteExample {

	public static void main(String[] args) throws IOException {
		Employee emp = JacksonObjectMapperExample.createEmployee();

		JsonGenerator jsonGenerator = new JsonFactory()
				.createGenerator(new FileOutputStream("stream_emp.txt"));
		//for pretty printing
		jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
		
		jsonGenerator.writeStartObject(); // start root object
		jsonGenerator.writeNumberField("id", emp.getId());
		jsonGenerator.writeStringField("name", emp.getName());
		jsonGenerator.writeBooleanField("permanent", emp.isPermanent());
		
		jsonGenerator.writeObjectFieldStart("address"); //start address object
			jsonGenerator.writeStringField("street", emp.getAddress().getStreet());
			jsonGenerator.writeStringField("city", emp.getAddress().getCity());
			jsonGenerator.writeNumberField("zipcode", emp.getAddress().getZipcode());
		jsonGenerator.writeEndObject(); //end address object
		
		jsonGenerator.writeArrayFieldStart("phoneNumbers");
			for(long num : emp.getPhoneNumbers())
				jsonGenerator.writeNumber(num);
		jsonGenerator.writeEndArray();
		
		jsonGenerator.writeStringField("role", emp.getRole());
		
		jsonGenerator.writeArrayFieldStart("cities"); //start cities array
		for(String city : emp.getCities())
			jsonGenerator.writeString(city);
		jsonGenerator.writeEndArray(); //closing cities array
		
		jsonGenerator.writeObjectFieldStart("properties");
			Set<String> keySet = emp.getProperties().keySet();
			for(String key : keySet){
				String value = emp.getProperties().get(key);
				jsonGenerator.writeStringField(key, value);
			}
		jsonGenerator.writeEndObject(); //closing properties
		jsonGenerator.writeEndObject(); //closing root object
		
		jsonGenerator.flush();
		jsonGenerator.close();
	}

}
