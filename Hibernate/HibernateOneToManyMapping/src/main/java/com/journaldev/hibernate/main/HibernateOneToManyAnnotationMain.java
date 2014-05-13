package com.journaldev.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Cart1;
import com.journaldev.hibernate.model.Items1;
import com.journaldev.hibernate.util.HibernateAnnotationUtil;

public class HibernateOneToManyAnnotationMain {

	public static void main(String[] args) {

		Cart1 cart = new Cart1();
		cart.setName("MyCart1");
		
		Items1 item1 = new Items1("I10", 10, 1, cart);
		Items1 item2 = new Items1("I20", 20, 2, cart);
		Set<Items1> itemsSet = new HashSet<Items1>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems1(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		//Save the Model object
		session.save(cart);
		session.save(item1);
		session.save(item2);
		//Commit transaction
		tx.commit();
		System.out.println("Cart1 ID="+cart.getId());
		System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
		System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart1().getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}
