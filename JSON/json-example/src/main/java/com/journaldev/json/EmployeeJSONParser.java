package com.journaldev.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.journaldev.model.Address;
import com.journaldev.model.Employee;

public class EmployeeJSONParser {

	public static final String FILE_NAME = "employee.txt";

	public static void main(String[] args) throws IOException {
		InputStream fis = new FileInputStream(FILE_NAME);

		JsonParser jsonParser = Json.createParser(fis);

		/**
		 * We can create JsonParser from JsonParserFactory also with below code
		 * JsonParserFactory factory = Json.createParserFactory(null);
		 * jsonParser = factory.createParser(fis);
		 */

		Employee emp = new Employee();
		Address address = new Address();
		String keyName = null;
		List<Long> phoneNums = new ArrayList<Long>();
		
		while (jsonParser.hasNext()) {
			Event event = jsonParser.next();
			switch (event) {
			case KEY_NAME:
				keyName = jsonParser.getString();
				break;
			case VALUE_STRING:
				setStringValues(emp, address, keyName, jsonParser.getString());
				break;
			case VALUE_NUMBER:
				setNumberValues(emp, address, keyName, jsonParser.getLong(), phoneNums);
				break;
			case VALUE_FALSE:
				setBooleanValues(emp, address, keyName, false);
				break;
			case VALUE_TRUE:
				setBooleanValues(emp, address, keyName, true);
				break;
			case VALUE_NULL:
				// don't set anything
				break;
			default:
				// we are not looking for other events
			}
		}
		emp.setAddress(address);
		long[] nums = new long[phoneNums.size()];
		int index = 0;
		for(Long l :phoneNums){
			nums[index++] = l;
		}
		emp.setPhoneNumbers(nums);
		
		System.out.println(emp);
		
		//close resources
		fis.close();
		jsonParser.close();
	}

	private static void setNumberValues(Employee emp, Address address,
			String keyName, long value, List<Long> phoneNums) {
		switch(keyName){
		case "zipcode":
			address.setZipcode((int)value);
			break;
		case "id":
			emp.setId((int) value);
			break;
		case "phoneNumbers":
			phoneNums.add(value);
			break;
		default:
			System.out.println("Unknown element with key="+keyName);	
		}
	}

	private static void setBooleanValues(Employee emp, Address address,
			String key, boolean value) {
		if("permanent".equals(key)){
			emp.setPermanent(value);
		}else{
			System.out.println("Unknown element with key="+key);
		}
	}

	private static void setStringValues(Employee emp, Address address,
			String key, String value) {
		switch(key){
		case "name":
			emp.setName(value);
			break;
		case "role":
			emp.setRole(value);
			break;
		case "city":
			address.setCity(value);
			break;
		case "street":
			address.setStreet(value);
			break;
		default:
			System.out.println("Unkonwn Key="+key);
				
		}
	}

}
