package com.journaldev.struts2.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.journaldev.struts2.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HomeAction extends ActionSupport implements ModelDriven<Employee>{

	private static final long serialVersionUID = 1L;

	@Override
	public String execute(){
		emp.setId(100);
		emp.setRole("Developer");
		
		List<String> cities = new ArrayList<String>();
		cities.add("San Jose");
		cities.add("New Delhi");
		cities.add("Bangalore");
		cities.add("Los Angeles");
		emp.setCitiesList(cities);
		
		List<String> countries = new ArrayList<String>();
		countries.add("India");
		countries.add("USA");
		countries.add("UK");
		emp.setCountryList(countries);
		
		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "10000$");
		props.put("group", "directors");
		props.put("company", "journaldev");
		props.put("age", "25 years");
		emp.setPropertiesMap(props);
		
		return SUCCESS;
	}

	public Decider getCountryDecider(){
		return new Decider(){

			@Override
			public boolean decide(Object obj) throws Exception {
				String input = (String) obj;
				if (input.equalsIgnoreCase("USA"))
					return false; //not included in sublist
				else
					return true; //included in sublist
			}
			
		};
	}
	
	private Employee emp = new Employee();

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public Employee getModel() {
		return emp;
	}
	
	
}
