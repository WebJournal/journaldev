package com.journaldev.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Cart;
import com.journaldev.hibernate.model.Items;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateOneToManyMain {

	public static void main(String[] args) {

		Cart cart = new Cart();
		cart.setName("MyCart");
		
		Items item1 = new Items("I1", 10, 1, cart);
		Items item2 = new Items("I2", 20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		//Get Session
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		//start transaction
		tx = session.beginTransaction();
		
		//Save the Model objects
		session.save(cart);
		session.save(item1);
		session.save(item2);
		
		//Commit transaction
		tx.commit();
		System.out.println("Cart ID="+cart.getId());
		
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
