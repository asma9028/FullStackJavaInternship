package com.kce.employee.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kce.employee.entity.Employee;
import com.kce.employee.util.HibernateUtil;

public class EmployeeDAO {
	private SessionFactory sessionFactory;
	private Session session;
	
	public void insert(Employee employee) {
		sessionFactory = HibernateUtil.getSession();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(employee);
		session.getTransaction().commit();
	}
	
	public void update(int empId, Employee employee) {
		sessionFactory = HibernateUtil.getSession();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee _employee = session.get(Employee.class, empId);
		if(_employee!=null) {
		_employee.setName(employee.getName());
		_employee.setDept(employee.getDept());
		_employee.setDesignation(employee.getDesignation());
		_employee.setSalary(employee.getSalary());
		session.merge(_employee);
		}
		session.getTransaction().commit();
		return;
	}
	
	public void delete(int empId) {
		sessionFactory = HibernateUtil.getSession();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee _employee = session.get(Employee.class, empId);
		if(_employee!=null) {
		session.remove(_employee);
		}
		session.getTransaction().commit();
		return;
	}
	
	public Employee getEmployeeById(int empId) {
		sessionFactory = HibernateUtil.getSession();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		Employee _employee = session.get(Employee.class, empId);
		session.getTransaction().commit();
		return _employee;
	}
	
	public List<Employee> getAllEmployees() {
		sessionFactory = HibernateUtil.getSession();
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		session.getTransaction().commit();
		return employeeList;
	}
}
