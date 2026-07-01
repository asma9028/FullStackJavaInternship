package com.kce.employee.service;

import java.util.List;



import com.kce.employee.dao.EmployeeDAO;
import com.kce.employee.entity.Employee;

public class EmployeeService {
	private EmployeeDAO employeeDAO;
	public String insert(Employee employee) {
		if(employee!=null && !employee.getName().trim().isEmpty() && !employee.getDesignation().trim().isEmpty() && employee.getSalary()>0 && !employee.getDept().trim().isEmpty()) {
			employeeDAO = new EmployeeDAO();
			employeeDAO.insert(employee);
			return "Employee Inserted successfully";
		}
		return "Cannot Insert Employee";
		
	}
	
	public String update(int empId, Employee employee) {
		employeeDAO = new EmployeeDAO();
		Employee _employee = employeeDAO.getEmployeeById(empId);
		if(_employee !=null) {
			employeeDAO.update(empId, employee);
			return "Employee updated Successfully";
		}
		return "Employee doesn't exist";
	}
	
	public String delete(int empId) {
		employeeDAO = new EmployeeDAO();
		if(getEmployeeById(empId)!=null) {
		employeeDAO.delete(empId);
		return "Employee Deleted Successfully";
		}
		return "Employee doesn't exist";
	}
	
	public Employee getEmployeeById(int empId) {
		employeeDAO = new EmployeeDAO();
		Employee _employee = employeeDAO.getEmployeeById(empId);
		return _employee;
	}
	
	public List<Employee> getAllEmployees(){
		employeeDAO = new EmployeeDAO();
		List<Employee> employeeList = employeeDAO.getAllEmployees();
		return employeeList;
	}
}
