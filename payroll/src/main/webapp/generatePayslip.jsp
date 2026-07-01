<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payslip Generate</title>
</head>
<body>
	<form action="main" method="post">
		<input type="hidden" name="operation" value="generate"/>
		<p>Employee ID : <input type="text" name="empId"/></p>
		<p>Month : <select name = "month">
		<option value="JAN">January</option>
		<option value="FEB">February</option>
		<option value="MAR">March</option>
		<option value="APR">April</option>
		<option value="MAY">May</option>
		<option value="JUN">June </option>
		<option value="JUL">July</option>
		<option value="AUG">August</option>
		<option value="SEP">September</option>
		<option value="OCT">October</option>
		<option value="NOV">November</option>
		<option value="DEC">December</option>
		</select></p>
		<p>Year : <input type="text" name="year"/></p>
		<p>Basic Salary : <input type="text" name="basic"/></p>
		<p>Commutation : <input type="text" name="commutation"/></p>
		<p>HR Allowance : <input type="text" name="hrAllowance"/></p>
		<button type="submit">Generate</button>
	</form>
</body>
</html>