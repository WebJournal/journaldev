package com.journaldev.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Cart;
import com.journaldev.hibernate.model.Item;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateBiDirectionalManyToManyMain {

	//Saving many-to-many where Item is primary
	public static void main(String[] args) {
		
		Item iphone = new Item();
		iphone.setPrice(100); iphone.setDescription("iPhone");
		
		Item ipod = new Item();
		ipod.setPrice(50); ipod.setDescription("iPod");
		
		Cart cart = new Cart();
		cart.setTotal(150);
		
		Cart cart1 = new Cart();
		cart1.setTotal(100);
		
		Set<Cart> cartSet = new HashSet<Cart>();
		cartSet.add(cart);cartSet.add(cart1);
		
		Set<Cart> cartSet1 = new HashSet<Cart>();
		cartSet1.add(cart);
		
		iphone.setCarts(cartSet1);
		ipod.setCarts(cartSet);
		
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(iphone);
		session.save(ipod);
		tx.commit();
		sessionFactory.close();
		
		System.out.println("Cart ID="+cart.getId());
		System.out.println("Cart1 ID="+cart1.getId());
		System.out.println("Item1 ID="+iphone.getId());
		System.out.println("Item2 ID="+ipod.getId());
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
		}
		
	}

}
