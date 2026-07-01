<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Rental</title>
</head>
<body>
	<form action="main" method="post">
		<input type="hidden" name="operation" value="newRecord"/>
		Customer Name : <input type="text" name="customerName"/><br/>
		Vehicle Type: <input type="text" name="vehicleType"/><br/>
		Rental Date : <input type="date" name="rentalDate"/><br/>
		Return Date : <input type="date" name="returnDate"/><br/>
		Amount : <input type="text" name="amount"/><br/>
		Remarks : <input type="text" name="remarks"/><br/>
		<button type="submit">Add Rental</button>
	</form>
</body>
</html>