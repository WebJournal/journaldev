package com.journaldev.jibx.test;

import java.io.StringReader;
import java.io.StringWriter;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import com.journaldev.jibx.bean.Employee;

public class JibxTest {
	public String marshalEmployee(Employee employee){
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Employee.class);
			IMarshallingContext mctx = bfact.createMarshallingContext();
			mctx.setIndent(2);
			StringWriter stringWriter = new StringWriter();
			mctx.setOutput(stringWriter);
			mctx.marshalDocument(employee, "UTF-8", null);
			String output = stringWriter.toString();
			return output;
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void unMarshalEmployee(String inputXml){
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Employee.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			StringReader stringReader = new StringReader(inputXml);
			Employee employee  = (Employee) uctx.unmarshalDocument(stringReader, null);
			System.out.println("Employee ID:"+employee.getId());
		} catch (JiBXException e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String args[]){
		String inputXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Employee id=\"237871\"><name>Cisco</name><hiredate>Jan 03, 2011</hiredate></Employee>";
		JibxTest jibxTest = new JibxTest();
		jibxTest.unMarshalEmployee(inputXml);
		
		Employee employee = new Employee();
		employee.setId("237871");
		employee.setName("Cisco");
		employee.setHireDate("Jan 03, 2011");
		
		System.out.println("Employee as XML String:"+jibxTest.marshalEmployee(employee));
	}
}
