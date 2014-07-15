package com.journaldev.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateExample {

	public static void main(String[] args) {
		
		//Prep Work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Get Example
		try{
		Employee emp = (Employee) session.get("com.journaldev.hibernate.model.Employee", new Long(2));
		System.out.println("Employee get called");
		if(emp != null){
		System.out.println("Employee GET ID= "+emp.getId());
		System.out.println("Employee Get Details:: "+emp+"\n");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//load Example
		try{
//		Employee emp1 = (Employee) session.load("com.journaldev.hibernate.model.Employee", new Long(1));
		Employee emp1 = new Employee();
		session.load(emp1, new Long(1));
		System.out.println("Employee load called");
		System.out.println("Employee LOAD ID= "+emp1.getId());
		System.out.println("Employee load Details:: "+emp1+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//byId example
//		Employee emp2 = (Employee) session.byId(Employee.class).getReference(new Long(3));
//		System.out.println("Employee byId called");
//		System.out.println("Employee ID= "+emp2.getId());
//		System.out.println("Employee byId Details:: "+emp2+"\n");
		
		
		//Close resources
		tx.commit();
		sessionFactory.close();
	}

}
