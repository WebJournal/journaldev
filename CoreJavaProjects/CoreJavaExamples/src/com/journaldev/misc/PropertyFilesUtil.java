package com.journaldev.misc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyFilesUtil {

	public static void main(String[] args) throws IOException {
		String propertyFileName = "DB.properties";
		String xmlFileName = "DB.xml";
		writePropertyFile(propertyFileName, xmlFileName);
		readPropertyFile(propertyFileName, xmlFileName);
		readAllKeys(propertyFileName, xmlFileName);
		readPropertyFileFromClasspath(propertyFileName);
	}

	/**
	 * read property file from classpath
	 * @param propertyFileName
	 * @throws IOException
	 */
	private static void readPropertyFileFromClasspath(String propertyFileName) throws IOException {
		Properties prop = new Properties();
		prop.load(PropertyFilesUtil.class.getClassLoader().getResourceAsStream(propertyFileName));
		System.out.println(propertyFileName +" loaded from Classpath::db.host = "+prop.getProperty("db.host"));
		System.out.println(propertyFileName +" loaded from Classpath::db.user = "+prop.getProperty("db.user"));
		System.out.println(propertyFileName +" loaded from Classpath::db.pwd = "+prop.getProperty("db.pwd"));
		System.out.println(propertyFileName +" loaded from Classpath::XYZ = "+prop.getProperty("XYZ"));
		
	}

	/**
	 * read all the keys from the given property files
	 * @param propertyFileName
	 * @param xmlFileName
	 * @throws IOException 
	 */
	private static void readAllKeys(String propertyFileName, String xmlFileName) throws IOException {
		System.out.println("Start of readAllKeys");
		Properties prop = new Properties();
		FileReader reader = new FileReader(propertyFileName);
		prop.load(reader);
		Set<Object> keys= prop.keySet();
		for(Object obj : keys){
			System.out.println(propertyFileName + ":: Key="+obj.toString()+"::value="+prop.getProperty(obj.toString()));
		}
		//loading xml file now, first clear existing properties
		prop.clear();
		InputStream is = new FileInputStream(xmlFileName);
		prop.loadFromXML(is);
		keys= prop.keySet();
		for(Object obj : keys){
			System.out.println(xmlFileName + ":: Key="+obj.toString()+"::value="+prop.getProperty(obj.toString()));
		}
		//Now free all the resources
		is.close();
		reader.close();
		System.out.println("End of readAllKeys");
	}

	/**
	 * This method reads property files from file system
	 * @param propertyFileName
	 * @param xmlFileName
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private static void readPropertyFile(String propertyFileName, String xmlFileName) throws FileNotFoundException, IOException {
		System.out.println("Start of readPropertyFile");
		Properties prop = new Properties();
		FileReader reader = new FileReader(propertyFileName);
		prop.load(reader);
		System.out.println(propertyFileName +"::db.host = "+prop.getProperty("db.host"));
		System.out.println(propertyFileName +"::db.user = "+prop.getProperty("db.user"));
		System.out.println(propertyFileName +"::db.pwd = "+prop.getProperty("db.pwd"));
		System.out.println(propertyFileName +"::XYZ = "+prop.getProperty("XYZ"));
		//loading xml file now, first clear existing properties
		prop.clear();
		InputStream is = new FileInputStream(xmlFileName);
		prop.loadFromXML(is);
		System.out.println(xmlFileName +"::db.host = "+prop.getProperty("db.host"));
		System.out.println(xmlFileName +"::db.user = "+prop.getProperty("db.user"));
		System.out.println(xmlFileName +"::db.pwd = "+prop.getProperty("db.pwd"));
		System.out.println(xmlFileName +"::XYZ = "+prop.getProperty("XYZ"));
		//Now free all the resources
		is.close();
		reader.close();
		System.out.println("End of readPropertyFile");
	}
	
	/**
	 * This method writes Property files into file system in property file
	 * and xml format
	 * @param fileName
	 * @throws IOException
	 */
	private static void writePropertyFile(String propertyFileName, String xmlFileName) throws IOException {
		System.out.println("Start of writePropertyFile");
		Properties prop = new Properties();
		prop.setProperty("db.host", "localhost");
		prop.setProperty("db.user", "user");
		prop.setProperty("db.pwd", "password");
		prop.store(new FileWriter(propertyFileName), "DB Config file");
		System.out.println(propertyFileName + " written successfully");
		prop.storeToXML(new FileOutputStream(xmlFileName), "DB Config XML file");
		System.out.println(xmlFileName + " written successfully");
		System.out.println("End of writePropertyFile");
	}

}
