<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.kce.employee.entity.Employee,java.util.List"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String msg = (String) request.getAttribute("message");
	if(msg!=null){ %>
	<%= msg %>
	<% } else{ 
		Employee employee = (Employee)request.getAttribute("employee");
		if(employee!=null){
			%>
			<h3>Employee Details</h3>
			<p>Employee ID : <%= employee.getEmpId() %></p>
			<p>Name : <%= employee.getName() %></p>
			<p>Department : <%= employee.getDept() %></p>
			<p>Designation : <%= employee.getDesignation() %></p>
			<p>Salary : <%= employee.getSalary() %></p>
			 <%
		}
		else{
			List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");
			if(employeeList!=null && !employeeList.isEmpty()){
			%>
			<table border="1" cellpadding="2">
			<tr>
			<th>Employee ID </th>
			<th>Name </th>
			<th>Department </th>
			<th>Designation </th>
			<th>Salary </th>
			</tr>
			
			<%
			for(Employee _employee : employeeList){
				%>
				<tr>
				<td><%= _employee.getEmpId() %></td>
				<td><%= _employee.getName() %></td>
				<td><%= _employee.getDept() %></td>
				<td><%= _employee.getDesignation() %></td>
				<td><%= _employee.getSalary() %></td>
				</tr>
				 <%
			}%>
			</table>
			<%
		}
		}}
		%>
	
</body>
</html>