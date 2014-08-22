package com.journaldev;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.journaldev.hibernate.data.Employee;

public class Main {
	public static void main(String [] args){
		// Create a configuration instance
		Configuration configuration = new Configuration();
		// Provide configuration file
		configuration.configure("hibernate.cfg.xml");
		// Build a SessionFactory
		SessionFactory factory = configuration.buildSessionFactory();
		// Get current session, current session is already associated with Thread
		Session session = factory.getCurrentSession();
		// Begin transaction, if you would like save your instances, your calling of save must be associated with a transaction
		session.getTransaction().begin();
		// Create employee
		Employee emp = new Employee();
		emp.setEmployeeName("Peter Jousha");
		emp.setEmployeeSalary(2000);
		emp.setEmployeeHireDate(new Date());
		// Save
		session.save(emp);
		// Commit, calling of commit will cause save an instance of employee
		session.getTransaction().commit();
	}
}
