<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList,com.wipro.bus.bean.ScheduleBean"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  ArrayList<ScheduleBean> res = (ArrayList<ScheduleBean>)request.getAttribute("schedules");
	if(res == null || res.isEmpty()){ %>
	<h1>No matching schedules exists! Please try again!</h1>
	<% 
	}
	else{
		%>
	<table border=1 cellpadding=2>
	<tr>
		<th>Schedule ID </th>
		<th>Source </th>
		<th>Destination</th>
		<th>Start Time</th>
		<th> Arrival Time </th>
		</tr>
	<% 
		for(int i=0;i<res.size();i++){
			%>
			<tr>
			<td><%= res.get(i).getScheduleId()%></td>
			<td><%= res.get(i).getSource()%></td>
			<td><%= res.get(i).getDestination()%></td>
			<td><%= res.get(i).getStartTime()%></td>
			<td><%= res.get(i).getArrivalTime()%></td>
			</tr>
		<%}}
	%>
	</table>
</body>
</html>