package com.journaldev.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.portlet.PortletPreferences;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.DefaultActionSupport;
import org.apache.struts2.portlet.interceptor.PortletPreferencesAware;

import com.journaldev.dao.EmployeeDAO;
import com.journaldev.data.Employee;

public class RegisterAction extends DefaultActionSupport implements PortletPreferencesAware {
	private static Logger logger = Logger.getLogger(RegisterAction.class);
	private static final long serialVersionUID = 1L;
	private PortletPreferences preferences;
	private String id;
	private String name;
	private String job;
	private String salary;
	
	public PortletPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(PortletPreferences preferences) {
		this.preferences = preferences;
	}

	@Override
	public void setPortletPreferences(PortletPreferences prefs) {
		this.preferences = prefs;
	}
	
	@Override
    public String execute() throws Exception {
		try {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.setJob(job);
			employee.setSalary(salary);
			// Register Employee
			employee = EmployeeDAO.getInstance().createEmployee(employee);
			logger.debug("Employee Has Registered");
			return "SUCCESS";
		} catch (IllegalAccessException | ClassNotFoundException | SQLException | IOException e) {
			logger.debug("Registration Process Has Failed",e);
			return "FAILURE";
		}
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	

}
