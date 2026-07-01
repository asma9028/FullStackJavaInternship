<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Search</h1>
	<form action="main" method="post">
		<input type="hidden" name="operation" value="viewForecast"/>
		Location : <input type="text" name="location"/><br/>
		Date : <input type="date" name="date"/><br/>
		<button type="submit">Search</button>
	</form>
</body>
</html>