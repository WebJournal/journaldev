package com.journaldev.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Address;
import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateSaveExample {

	public static void main(String[] args) {
		
		// Prep Work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//save example - without transaction
		Session session = sessionFactory.openSession();
		Employee emp = getTestEmployee();
		long id = (Long) session.save(emp);
		System.out.println("1. Employee save called without transaction, id="+id);
		session.flush();
		System.out.println("*****");
		
		//save example - with transaction
		Transaction tx1 = session.beginTransaction();
		Session session1 = sessionFactory.openSession();
		Employee emp1 = getTestEmployee();
		long id1 = (Long) session1.save(emp1);
		System.out.println("2. Employee save called with transaction, id="+id1);
		System.out.println("3. Before committing save transaction");
		tx1.commit();
		System.out.println("4. After committing save transaction");
		System.out.println("*****");
		
		//save example - existing row in table
		Session session6 = sessionFactory.openSession();
		Transaction tx6 = session6.beginTransaction();
		Employee emp6 =  (Employee) session6.load(Employee.class, new Long(20));
		
		//update some data
		System.out.println("Employee Details="+emp6);
		emp6.setName("New Name");
		emp6.getAddress().setCity("New City");
		
		long id6 = (Long) session6.save(emp6);
		emp.setName("New Name1");
		System.out.println("5. Employee save called with transaction, id="+id6);
		System.out.println("6. Before committing save transaction");
		tx6.commit();
		System.out.println("7. After committing save transaction");
		System.out.println("*****");
		
		// Close resources
		sessionFactory.close();

	}

	public static Employee getTestEmployee() {
		Employee emp = new Employee();
		Address add = new Address();
		emp.setName("Test Emp");
		emp.setSalary(1000);
		add.setAddressLine1("Test address1");
		add.setCity("Test City");
		add.setZipcode("12121");
		emp.setAddress(add);
		add.setEmployee(emp);
		return emp;
	}
}
