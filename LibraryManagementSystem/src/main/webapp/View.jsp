<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.wipro.book.bean.BookBean"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String bookName = (String)request.getAttribute("title");
String author = (String)request.getAttribute("author");%>
<h1>Book Details</h1>
<table border="1" cellpadding="2">
<tr>
<th>Title</th>
<th>Author</th>
</tr>
<tr>
<td><%= bookName %></td>
<td><%= author %>
</tr>
</table>
</body>
</html>