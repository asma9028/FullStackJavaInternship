<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Forecast</h1>
	<form action="main" method="post">
		<input type="hidden" name="operation" value="newForecast">
		Location : <input type="text" name="location"/><br>
		Date : <input type="date" name="date"/><br/>
		Temperature : <input type="text" name="temperature"/><br/>
		Humidity : <input type="text" name="humidity"/><br/>
		Wind : <input type="text" name="wind"/><br/>
		Forecast : <input type="text" name="forecast"/><br/>
		<button type="submit">Add Forecast</button>
	</form>
</body>
</html>