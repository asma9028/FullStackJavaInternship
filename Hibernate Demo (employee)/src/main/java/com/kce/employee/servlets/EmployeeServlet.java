package com.kce.employee.servlets;

import java.io.IOException;

import java.util.List;

import com.kce.employee.entity.Employee;
import com.kce.employee.service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
	private EmployeeService employeeService;

	protected void doPost(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		employeeService = new EmployeeService();
		if(operation.equals("insert")) {
			String name = request.getParameter("name");
			String dept = request.getParameter("dept");
			String designation = request.getParameter("designation");
			float salary = Float.parseFloat(request.getParameter("salary"));
			Employee _employee = new Employee();
			_employee.setName(name);
			_employee.setDept(dept);
			_employee.setDesignation(designation);
			_employee.setSalary(salary); 
			String result = employeeService.insert(_employee);
			request.setAttribute("message", result);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}
		else if(operation.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String dept = request.getParameter("dept");
			String designation = request.getParameter("designation");
			float salary = Float.parseFloat(request.getParameter("salary"));
			Employee _employee = new Employee();
			_employee.setName(name);
			_employee.setDept(dept);
			_employee.setDesignation(designation);
			_employee.setSalary(salary);
			String result =  employeeService.update(id,_employee);
			request.setAttribute("message", result);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}
		else if(operation.equals("delete")) {
			int empId = Integer.parseInt(request.getParameter("id"));
			String result = employeeService.delete(empId);
			request.setAttribute("message", result);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}
		else if(operation.equals("fetch")) {
			int empId = Integer.parseInt(request.getParameter("id"));
			Employee _employee = employeeService.getEmployeeById(empId);
			request.setAttribute("employee", _employee);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}
		else if(operation.equals("fetch all")) {
			List<Employee> employeeList = employeeService.getAllEmployees();
			request.setAttribute("employeeList", employeeList);
			RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}
	

}}
