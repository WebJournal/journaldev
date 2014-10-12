package com.journaldev.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.journaldev.dao.EmployeeDAO;
import com.journaldev.data.Employee;

public class RegisterEmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(RegisterEmployeeServlet.class);
       
    public RegisterEmployeeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create employee
		Employee employee = new Employee();
		// Fill in required data from the request sent
		employee.setId(Integer.parseInt(request.getParameter("employeeID")));
		employee.setName(request.getParameter("employeeName"));
		employee.setJob(request.getParameter("employeeJob"));
		employee.setSalary(Integer.parseInt(request.getParameter("employeeSalary")));
		try {
			// Asking employeeDAO creating the employee against registered database
			Employee createdEmployee = EmployeeDAO.getInstance().createEmployee(employee);
			// Print out the created employee information
			logger.info("Employee Created"+createdEmployee);
		} catch (Exception e) {
			// Log the exception
			logger.error("Employee Creation Failed", e);
			// Throw another exception for notifying the Portlet
			throw new ServletException(e);
		}
	}

}
