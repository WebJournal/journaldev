package com.journaldev.json.gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.journaldev.json.model.Address;
import com.journaldev.json.model.Employee;

public class EmployeeGsonReader {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("employee.txt");
		InputStreamReader isr = new InputStreamReader(is);
		
		//create JsonReader object
		JsonReader reader = new JsonReader(isr);
		
		//create objects
		Employee emp = new Employee();
		Address add = new Address();
		emp.setAddress(add);
		List<Long> phoneNums = new ArrayList<Long>();
		emp.setCities(new ArrayList<String>());
		emp.setProperties(new HashMap<String, String>());
		String key = null;
		boolean insidePropertiesObj=false;
		
		key = parseJSON(reader, emp, phoneNums, key, insidePropertiesObj);
		
		
		long[] nums = new long[phoneNums.size()];
		int index = 0;
		for(Long l :phoneNums){
			nums[index++] = l;
		}
		emp.setPhoneNumbers(nums);
		
		reader.close();
		//print employee object
		System.out.println("Employee Object\n\n"+emp);
	}
	
	

	private static String parseJSON(JsonReader reader, Employee emp,
			List<Long> phoneNums, String key, boolean insidePropertiesObj) throws IOException {
		
		//loop to read all tokens
				while(reader.hasNext()){
					//get next token
					JsonToken token = reader.peek();
					
					switch(token){
					case BEGIN_OBJECT:
						reader.beginObject();
						if("address".equals(key) || "properties".equals(key)){
							while(reader.hasNext()){
							parseJSON(reader, emp,phoneNums, key, insidePropertiesObj);
							}
							reader.endObject();
						}
						break;
					case END_OBJECT:
						reader.endObject();
						if(insidePropertiesObj) insidePropertiesObj=false;
						break;
					case BEGIN_ARRAY:
						reader.beginArray();
						if("phoneNumbers".equals(key) || "cities".equals(key)){
							while(reader.hasNext()){
								parseJSON(reader, emp,phoneNums, key, insidePropertiesObj);
								}
							reader.endArray();
						}
						break;
					case END_ARRAY:
						reader.endArray();
						break;
					case NAME:
						key = reader.nextName();
						if("properties".equals(key)) insidePropertiesObj=true;
						break;
					case BOOLEAN:
						if("permanent".equals(key)) emp.setPermanent(reader.nextBoolean());
						else{
							System.out.println("Unknown item found with key="+key);
							//skip value to ignore it
							reader.skipValue();
						}
						break;
					case NUMBER:
						if("empID".equals(key)) emp.setId(reader.nextInt());
						else if("phoneNumbers".equals(key)) phoneNums.add(reader.nextLong());
						else if("zipcode".equals(key)) emp.getAddress().setZipcode(reader.nextInt());
						else {
							System.out.println("Unknown item found with key="+key);
							//skip value to ignore it
							reader.skipValue();
						}
						break;
					case STRING:
						setStringValues(emp, key, reader.nextString(), insidePropertiesObj);
						break;
					case NULL:
						System.out.println("Null value for key"+key);
						reader.nextNull();
						break;
					case END_DOCUMENT:
						System.out.println("End of Document Reached");
						break;
					default:
						System.out.println("This part will never execute");
						break;
						
					}
				}
				return key;
	}



	private static void setStringValues(Employee emp, String key,
			String value, boolean insidePropertiesObj) {
		if("name".equals(key)) emp.setName(value);
		else if("role".equals(key)) emp.setRole(value);
		else if("cities".equals(key)) emp.getCities().add(value);
		else if ("street".equals(key)) emp.getAddress().setStreet(value);
		else if("city".equals(key)) emp.getAddress().setCity(value);
		else{
			//add to emp properties map
			if(insidePropertiesObj){
				emp.getProperties().put(key, value);
			}else{
				System.out.println("Unknown data found with key="+key+" value="+value);
			}
			
		}
	}

}
