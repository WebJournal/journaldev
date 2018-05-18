package com.journaldev.hibernate.main;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateLog4jExample {

	static{
		System.out.println("Before log4j configuration");
		DOMConfigurator.configure("log4j.xml");
		System.out.println("After log4j configuration");
	}
	
	private static Logger logger = Logger.getLogger(HibernateLog4jExample.class);
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		//Get All Employees
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> empList = query.list();
		for(Employee emp : empList){
			logger.info("List of Employees::"+emp.getId()+","+emp.getAddress().getCity());
		}
		
		tx.commit();
		sessionFactory.close();
		logger.info("DONE");
	}

}
