package com.kce.employee.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure("hiber.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;
	}
}
