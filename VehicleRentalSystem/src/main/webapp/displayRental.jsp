<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.wipro.vehicle.bean.VehicleBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rental Details</title>
</head>
<body>
<% String msg = (String)request.getAttribute("message");
if(msg!=null){
%>
<h3><%=msg %></h3>
<%
}
else{
	VehicleBean _vehicleBean = (VehicleBean) request.getAttribute("vehicleBean");
	%>
	<h4>Record ID : <%= _vehicleBean.getRecordId() %></h4>
	<h4>Customer Name : <%=_vehicleBean.getCustomerName() %></h4>
	<h4>Vehicle Type : <%= _vehicleBean.getVehicleType() %></h4>
	<h4>Rental Date : <%= _vehicleBean.getRentalDate() %></h4>
	<h4>Return Date : <%=_vehicleBean.getReturnDate() %></h4>
	<h4>Amount : <%= _vehicleBean.getAmount() %></h4>
	<h4>Remarks : <%=_vehicleBean.getRemarks() %></h4>
	<%
}
%>

</body>
</html>