package com.nagarro.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.dto.Flight;
import com.nagarro.dto.User;

public class SessionBuilder {

	public static Session buildSession() {

		Configuration con = new Configuration().configure().addAnnotatedClass(Flight.class)
				.addAnnotatedClass(User.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		return session;

	}
}
