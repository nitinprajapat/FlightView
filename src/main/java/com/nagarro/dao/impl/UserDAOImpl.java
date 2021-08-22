package com.nagarro.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.dao.UserDAO;
import com.nagarro.dto.User;
import com.nagarro.util.SessionBuilder;

public class UserDAOImpl implements UserDAO {

	public void saveUser() {
		User credential1 = new User();
		User credential2 = new User();
		User credential3 = new User();
		User credential4 = new User();
		credential1.setUsername("nitin");
		credential1.setPassword("Nitin@123");
		credential2.setUsername("rahul");
		credential2.setPassword("Rahul@123");
		credential3.setUsername("ram");
		credential3.setPassword("Ram@123");
		credential4.setUsername("ajay");
		credential4.setPassword("Ajay@123");

		Session session = SessionBuilder.buildSession();

		Transaction tran = session.beginTransaction();
		session.save(credential1);
		session.save(credential2);
		session.save(credential3);
		session.save(credential4);

		tran.commit();

	}

	public User getUser(String username) {
		// TODO Auto-generated method stub

		User user = new User();

		Session session = SessionBuilder.buildSession();

		Transaction tx = session.beginTransaction();

		user = session.get(User.class, username);

		tx.commit();

		return user;
	}
}
