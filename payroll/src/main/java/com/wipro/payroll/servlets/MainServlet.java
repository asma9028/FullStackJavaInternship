
package com.wipro.payroll.servlets;

import java.io.IOException;


import com.wipro.payroll.bean.PayslipBean;
import com.wipro.payroll.service.Administrator;
import com.wipro.payroll.util.InvalidInputException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private Administrator admin;
	
	public String generatePayslip(HttpServletRequest request) throws InvalidInputException {
		PayslipBean payslipBean = new PayslipBean();
		String empId = request.getParameter("empId");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		double basic = Double.parseDouble(request.getParameter("basic"));
		double commutation = Double.parseDouble(request.getParameter("commutation"));
		double hrAllowance = Double.parseDouble(request.getParameter("hrAllowance"));
		payslipBean.setEmpid(empId);
		payslipBean.setMonth(month);
		payslipBean.setYear(year);
		payslipBean.setBasic(basic);
		payslipBean.setCommutation(commutation);
		payslipBean.setHrAllowance(hrAllowance);
		admin = new Administrator();
		return admin.addPayslip(payslipBean);
	}
	
	public PayslipBean viewPayslip(HttpServletRequest request) {
		String empId = request.getParameter("empId");
		admin = new Administrator();
		return admin.viewPayslip(empId);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("generate")) {
			String result = "FAIL";
			try {
				result = generatePayslip(request);
			} catch (InvalidInputException e) {
				e.printStackTrace();
			}
			if(result.equals("SUCCESS")) {
				response.sendRedirect("success.html");
			}
			else {
				response.sendRedirect("error.html");
			}
		}
		else if(operation.equals("view")) {
			PayslipBean payslipBean = viewPayslip(request);
			if(payslipBean!=null) {
				request.setAttribute("payslipBean", payslipBean);
				RequestDispatcher rd = request.getRequestDispatcher("displayPayslip.jsp");
				rd.forward(request,response);
			}
			else {
				String message = "No matching records exists! Please try again!";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("displayPayslip.jsp");
				rd.forward(request,response);
			}
		}
	}

}
