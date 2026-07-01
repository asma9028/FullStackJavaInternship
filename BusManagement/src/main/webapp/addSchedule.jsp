<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="main" method="post">
		<h1>Enter Schedule Details</h1>
		<input type="hidden" name ="operation" value="newSchedule"/>
		Source : <input type = "text" name = "source"/><br/>
		Destination : <input type = "text" name = "destination"/><br/>
		Start Time : <input type = "text" name = "startTime"/><br/>
		Arrival Time : <input type = "text" name = "arrivalTime"/><br/>
		<button type="submit" >Create Schedule</button>
	</form>
</body>
</html>