<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Rental</title>
</head>
<body>
	<form action="main" method="post">
		<input type="hidden" name="operation" value="viewRecord"/>
		Customer Name : <input type="text" name="customerName"/>
		Rental Date : <input type="date" name="rentalDate"/>
		<button type="Submit">View Record</button>
	</form>

</body>
</html>