<%@ page language="java" contentType="text/html; charset=UTF-8" import ="com.wipro.payroll.bean.PayslipBean"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payslip Details</title>
</head>
<body>
	<% String msg = (String)request.getAttribute("message");
		if(msg!=null){ %>
		 <h2><%= msg %></h2>
		 <% } else { 
			 PayslipBean _payslipBean = (PayslipBean)request.getAttribute("payslipBean");
			 if(_payslipBean!=null){%>
		 <h1>Payslip Details</h1>
		 <p>Employee ID : <%= _payslipBean.getEmpid() %></p>
		 <p>Month : <%= _payslipBean.getMonth() %></p>
		 <p>Year : <%= _payslipBean.getYear() %></p>
		 <p>Basic Salary : <%= _payslipBean.getBasic() %></p>
		 <p>Commutation : <%= _payslipBean.getCommutation() %></p>
		 <p>HR Allowance : <%= _payslipBean.getHrAllowance() %></p>
		 <p>Provident Fund : <%= _payslipBean.getProvidentFund() %></p>
		 <p>Total Salary : <%= _payslipBean.getTotalSalary() %></p>
		 <p>Income Tax : <%= _payslipBean.getIncomeTax() %></p>
		 <p>Payable Amount : <%= _payslipBean.getPayableAmount() %></p>
		 <% }} %>
</body>
</html>