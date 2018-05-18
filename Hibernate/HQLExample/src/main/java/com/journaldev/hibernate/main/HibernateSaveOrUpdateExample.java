package com.journaldev.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateSaveOrUpdateExample {

	public static void main(String[] args) {
		
		// Prep Work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//saveOrUpdate example - without transaction
		Session session5 = sessionFactory.openSession();
		Employee emp5 = HibernateSaveExample.getTestEmployee();
		session5.saveOrUpdate(emp5);
		System.out.println("*****");
		
		//saveOrUpdate example - with transaction
		Session session3 = sessionFactory.openSession();
		Transaction tx3 = session3.beginTransaction();
		Employee emp3 = HibernateSaveExample.getTestEmployee();
		session3.saveOrUpdate(emp3);
		emp3.setName("Kumar"); //will be saved into DB
		System.out.println("9. Before committing saveOrUpdate transaction. Id="+emp3.getId());
		tx3.commit();
		System.out.println("10. After committing saveOrUpdate transaction");
		System.out.println("*****");
		
		
		Transaction tx4 = session3.beginTransaction();
		emp3.setName("Updated Test Name"); //Name changed
		emp3.getAddress().setCity("Updated City");
		session3.saveOrUpdate(emp3);
		emp3.setName("Kumar"); //again changed to previous value, so no Employee update
		System.out.println("11. Before committing saveOrUpdate transaction. Id="+emp3.getId());
		tx4.commit();
		System.out.println("12. After committing saveOrUpdate transaction");
		System.out.println("*****");

		//update example
//		emp3.setName("Final updated name");
//		emp3.getAddress().setCity("Bangalore");
//		Transaction tx7 = session3.beginTransaction();
//		session3.update(emp3);
//		System.out.println("13. Before committing update transaction");
//		tx7.commit();
//		System.out.println("14. After committing update transaction");
//		
//		//merge example - data already present in tables
//		emp3.setSalary(25000);
//		Transaction tx8 = session3.beginTransaction();
//		Employee emp4 = (Employee) session3.merge(emp3);
//		System.out.println(emp4 == emp3); // returns true
//		emp3.setName("Test");
//		emp4.setName("Kumar");
//		System.out.println("15. Before committing merge transaction");
//		tx8.commit();
//		System.out.println("16. After committing merge transaction");
//		
//		//merge example - new data
//		Employee emp9 = getTestEmployee();
//		Session session4 = sessionFactory.openSession();
//		Transaction tx9 = session4.beginTransaction();
//		Employee emp10 = (Employee) session4.merge(emp9);
//		System.out.println(emp9 == emp10); // returns true
//		emp9.setName("Test");
//		emp10.setName("Kumar");
//		System.out.println("17. Before committing merge transaction");
//		tx9.commit();
//		System.out.println("18. After committing merge transaction");
		
		// Close resources
		sessionFactory.close();

	}


}
