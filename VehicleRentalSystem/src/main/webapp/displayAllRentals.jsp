<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.wipro.vehicle.bean.VehicleBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Rentals</title>
</head>
<body>
	<%String msg = (String) request.getAttribute("message"); 
	  if(msg!= null){
	  	%>
	  	<h3><%= msg %></h3>
	 <%
	  }
	  else{ 
		  List<VehicleBean> records = (List<VehicleBean>)request.getAttribute("records");
		  %>
		  <table border="1" cellpadding="1">
		  <tr>
		  <th>Record ID</th>
		  <th>Customer Name</th>
		  <th>Vehicle Type</th>
		  <th>Rental Date</th>
		  <th>Return Date </th>
		  <th>Amount </th>
		  <th>Remarks </th>
		  </tr>
		  <% 
		  for(VehicleBean vehicleBean : records){
			  %>
			  <tr>
			  <td><%= vehicleBean.getRecordId() %></td>
			  <td><%= vehicleBean.getCustomerName() %></td>
			  <td><%= vehicleBean.getVehicleType() %></td>
			  <td><%= vehicleBean.getRentalDate() %></td>
			  <td><%= vehicleBean.getReturnDate() %></td>
			  <td><%= vehicleBean.getAmount()  %></td>
			  <td><%= vehicleBean.getRemarks()  %></td>
			  </tr>
			  <% 
		  }
		  %>
		  </table>
		  <%
	  }
	  %>
	  
</body>
</html>