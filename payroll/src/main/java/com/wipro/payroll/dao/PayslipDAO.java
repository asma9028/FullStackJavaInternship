package com.wipro.payroll.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wipro.payroll.bean.PayslipBean;
import com.wipro.payroll.util.HibernateUtil;


public class PayslipDAO {
		private SessionFactory sessionFactory;
		private Session session;
		
		
	public String createPayslip(PayslipBean payslipBean) {
		session = sessionFactory.openSession();
		sessionFactory = HibernateUtil.getSessionFactory();
		Transaction tx = session.beginTransaction();
		try {
		session.persist(payslipBean);
		tx.commit();
		return "SUCCESS";
		}
		catch(Exception e) {
			tx.rollback();
			return "FAIL";
		}
	}
	
	public PayslipBean fetchPayslip(String empID) {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession(); 
		PayslipBean payslipBean = session.get(PayslipBean.class, empID);
		return payslipBean;
	}
	
	public boolean payslipExists(String empID) {
		if(fetchPayslip(empID) != null) {
			return true;
		}
		return false;
	}
}
