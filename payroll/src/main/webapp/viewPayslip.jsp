<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Payslip</title>
</head>
<body>
	<form action="main" method="post">
		<input type="hidden" name="operation" value="view"/>
		<p>Employee ID : <input type="text" name="empId"/></p>
		<button type="submit">View</button>
	</form>
	
	
</body>
</html>