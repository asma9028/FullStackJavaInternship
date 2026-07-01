<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.wipro.weather.bean.WeatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String msg = (String) request.getAttribute("message");
if(msg!=null){
	%>
	<%= msg %>
	<%
}
else{
	WeatherBean weatherBean = (WeatherBean) request.getAttribute("weatherBean");
	%>
	Report ID : <%= weatherBean.getReportId() %>
	Location : <%= weatherBean.getLocation() %>
	Date : <%= weatherBean.getDate() %>
	Humidity : <%= weatherBean.getHumidity() %>
	Temperature : <%= weatherBean.getTemperature() %>
	Wind : <%= weatherBean.getWind() %>
	Forecast : <%= weatherBean.getForecast() %>
	<%
}
%>
</body>
</html>