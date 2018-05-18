package com.journaldev.beans;

import java.io.IOException;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.journaldev.dao.EmployeeDAO;
import com.journaldev.data.Employee;

@ManagedBean
@SessionScoped
public class RegisterEmployeeManagedBean {
	private static Logger logger = Logger.getLogger(RegisterEmployeeManagedBean.class);
	private Employee employee = new Employee();
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void registerListener(ActionEvent event){
		try {
			// Register Employee
			this.employee = EmployeeDAO.getInstance().createEmployee(employee);
			logger.debug("Employee Has Registered");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Employee has regisered successfully !",""));
			// Reset employee
			this.employee = new Employee();
		} catch (IllegalAccessException | ClassNotFoundException | SQLException | IOException e) {
			logger.debug("Registration Process Has Failed",e);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Unforunately!, employee hasn't registered cause to : "+e,""));			
		}
	}
}
