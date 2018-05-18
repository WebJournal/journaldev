package com.journaldev.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernatePersistExample {

	public static void main(String[] args) {
		
		// Prep Work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		
		//persist example - with transaction
		Session session2 = sessionFactory.openSession();
		Transaction tx2 = session2.beginTransaction();
		Employee emp2 = HibernateSaveExample.getTestEmployee();
		session2.persist(emp2);
		System.out.println("Persist called");
		emp2.setName("Kumar"); // will be updated in database too
		System.out.println("Employee Name updated");
		System.out.println("8. Employee persist called with transaction, id="+emp2.getId()+", address id="+emp2.getAddress().getId());
		tx2.commit();
		System.out.println("*****");
		
		// Close resources
		sessionFactory.close();

	}

}
