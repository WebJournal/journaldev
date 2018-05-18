package com.journaldev.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HQLCacheExample {

	public static void main(String[] args) {
		// Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();

		// Get Employee with id=3
		Query query = session.createQuery("from Employee where id= 3");
		Employee emp = (Employee) query.uniqueResult();
		System.out.println("Employee Name=" + emp.getName() + ", City="
				+ emp.getAddress().getCity());

		// Get Employee with id=3
		query = session.createQuery("from Employee where id= 3");
		emp = (Employee) query.uniqueResult();
		System.out.println("Employee Name=" + emp.getName() + ", City="
				+ emp.getAddress().getCity());

		// Get Employee with id=3
		query = session.createQuery("from Employee where id= 3");
		emp = (Employee) query.uniqueResult();
		System.out.println("Employee Name=" + emp.getName() + ", City="
				+ emp.getAddress().getCity());

		// rolling back to save the test data
		tx.commit();

		// closing hibernate resources
		sessionFactory.close();

	}

}
