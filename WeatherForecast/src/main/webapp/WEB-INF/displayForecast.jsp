<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.wipro.weather.bean.WeatherBean,java.util.Date"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String msg = request.getParameter("message");
String reportId=null,location=null,wind=null,forecast=null;
Date date=null;
int temperature=0,humidity=0;
if(msg!=null){ %>
<%= msg %>
<% 
}
else{
	WeatherBean weatherBean = (WeatherBean)request.getAttribute("weatherBean");
	reportId = weatherBean.getReportId();
	location = weatherBean.getLocation();
	date = weatherBean.getDate();
	temperature = weatherBean.getTemperature();
	humidity = weatherBean.getHumidity();
	wind = weatherBean.getWind();
	forecast = weatherBean.getForecast();
	%>
	
	<%
}
%>

<table border="1">
<tr><th>Report ID</th><td><%= reportId %></td></tr>
<tr><th>Location</th><td><%= location %></td></tr>
<tr><th>Date</th><td><%= date %></td></tr>
<tr><th>Temperature</th><td><%= temperature %></td></tr>
<tr><th>Humidity</th><td><%= humidity %></td></tr>
<tr><th>Wind</th><td><%= wind %></td></tr>
<tr><th>Forecast</th><td><%= forecast %></td></tr>
</table>
</body>
</html>