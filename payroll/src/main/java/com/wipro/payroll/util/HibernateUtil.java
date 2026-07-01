package com.wipro.payroll.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			sessionFactory = new Configuration().configure("hiber.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;
	}
}
