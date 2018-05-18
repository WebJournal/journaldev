package com.journaldev.struts2hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.struts2hibernate.model.User;

public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sf;
	
	public UserDAOImpl(SessionFactory sf){
		this.sf = sf;
	}

	@Override
	public User getUserByCredentials(String userId, String password) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User where id=:id and pwd=:pwd");
		query.setString("id", userId); query.setString("pwd", password);
		User user = (User) query.uniqueResult();
		if(user != null){
			System.out.println("User Retrieved from DB::"+user);
		}
		tx.commit();session.close();
		return user;
	}

}
