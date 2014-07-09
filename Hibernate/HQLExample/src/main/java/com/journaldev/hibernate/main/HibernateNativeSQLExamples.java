package com.journaldev.hibernate.main;

import java.util.List;

import org.hibernate.type.DoubleType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Address;
import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateNativeSQLExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Prep work
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		// Get All Employees
		Transaction tx = session.beginTransaction();
		SQLQuery query = session
				.createSQLQuery("select emp_id, emp_name, emp_salary from Employee");
		List<Object[]> rows = query.list();
		for (Object[] row : rows) {
			Employee emp = new Employee();
			emp.setId(Long.parseLong(row[0].toString()));
			emp.setName(row[1].toString());
			emp.setSalary(Double.parseDouble(row[2].toString()));
			System.out.println(emp);
		}
		System.out.println("**************");

		// Get All Employees - addScalar example
		query = session
				.createSQLQuery(
						"select emp_id, emp_name, emp_salary from Employee")
				.addScalar("emp_id", new LongType())
				.addScalar("emp_name", new StringType())
				.addScalar("emp_salary", new DoubleType());
		rows = query.list();
		for (Object[] row : rows) {
			Employee emp = new Employee();
			emp.setId(Long.parseLong(row[0].toString()));
			emp.setName(row[1].toString());
			emp.setSalary(Double.parseDouble(row[2].toString()));
			System.out.println(emp);
		}
		System.out.println("**************");

		// Entity query - addEntity example
		query = session
				.createSQLQuery("select e.emp_id, emp_name, emp_salary,address_line1, city, zipcode from Employee e, Address a where a.emp_id=e.emp_id");
		rows = query.list();
		for (Object[] row : rows) {
			Employee emp = new Employee();
			emp.setId(Long.parseLong(row[0].toString()));
			emp.setName(row[1].toString());
			emp.setSalary(Double.parseDouble(row[2].toString()));
			Address address = new Address();
			address.setAddressLine1(row[3].toString());
			address.setCity(row[4].toString());
			address.setZipcode(row[5].toString());
			emp.setAddress(address);
			System.out.println(emp);
		}
		System.out.println("**************");

		query = session
				.createSQLQuery("select emp_id, emp_name, emp_salary from Employee where emp_id = ?");
		List<Object[]> empData = query.setLong(0, 1L).list();
		for (Object[] row : empData) {
			Employee emp = new Employee();
			emp.setId(Long.parseLong(row[0].toString()));
			emp.setName(row[1].toString());
			emp.setSalary(Double.parseDouble(row[2].toString()));
			System.out.println(emp);
		}

		query = session
				.createSQLQuery("select emp_id, emp_name, emp_salary from Employee where emp_id = :id");
		empData = query.setLong("id", 2L).list();
		for (Object[] row : empData) {
			Employee emp = new Employee();
			emp.setId(Long.parseLong(row[0].toString()));
			emp.setName(row[1].toString());
			emp.setSalary(Double.parseDouble(row[2].toString()));
			System.out.println(emp);
		}

		// Join example with addEntity and addJoin
		query = session
				.createSQLQuery(
						"select {e.*}, {a.*} from Employee e join Address a ON e.emp_id=a.emp_id")
				.addEntity("e", Employee.class).addJoin("a", "e.address");
		rows = query.list();
		for (Object[] row : rows) {
			for (Object obj : row) {
				System.out.print(obj + "::");
			}
			System.out.println("\n");
		}
		//Above join returns both Employee and Address Objects in the array
		for (Object[] row : rows) {
			Employee e = (Employee) row[0];
			System.out.println("Employee Info::"+e);
			Address a = (Address) row[1];
			System.out.println("Address Info::"+a);
		}
		System.out.println("**************");

		// rolling back to save the test data
		tx.rollback();

		// closing hibernate resources
		sessionFactory.close();
	}

}
