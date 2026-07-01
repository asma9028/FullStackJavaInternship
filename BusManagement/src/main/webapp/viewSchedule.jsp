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
		<input type="hidden" name="operation" value="viewSchedule"/>
		Enter Source : <input type="text" name="source"/>
		Enter Destination : <input type ="text" name="destination"/>
		<button type="submit">Search Schedule</button>
	</form>
</body>
</html>