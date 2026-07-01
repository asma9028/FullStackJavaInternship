package com.wipro.vehicle.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.wipro.vehicle.bean.VehicleBean;
import com.wipro.vehicle.service.Administrator;
import com.wipro.vehicle.util.InvalidInputException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	Administrator admin;
	public String addRecord(HttpServletRequest request) throws ParseException, InvalidInputException {
		admin = new Administrator();
		VehicleBean _vehicleBean = new VehicleBean();
		_vehicleBean.setCustomerName(request.getParameter("customerName"));
		_vehicleBean.setVehicleType(request.getParameter("vehicleType"));
		String str_rental_date = request.getParameter("rentalDate");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		_vehicleBean.setRentalDate(format1.parse(str_rental_date));
		String str_return_date = request.getParameter("returnDate");
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		_vehicleBean.setReturnDate(format2.parse(str_return_date));
		_vehicleBean.setAmount(Integer.parseInt(request.getParameter("amount")));
		_vehicleBean.setRemarks(request.getParameter("remarks"));
		return admin.addRecord(_vehicleBean);
	}
	
	
	public VehicleBean viewRecord(HttpServletRequest request) throws ParseException {
		admin = new Administrator();
		String customerName = request.getParameter("customerName");
		String str_date = request.getParameter("rentalDate");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(str_date);
		return admin.viewRecord(customerName, new java.sql.Date(date.getTime()));
	}
	
	public List<VehicleBean> viewAllRecords(HttpServletRequest request){
		admin = new Administrator();
		return admin.viewAllRecords();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("newRecord")) {
			try {
			String result = addRecord(request);
				if(result.equals("FAIL")) {
					response.sendRedirect("error.html");
				}
				else {
					response.sendRedirect("success.html");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.html");
			}
		}
		else if(operation.equals("viewRecord")) {
			VehicleBean _vehicleBean = null;
			try {
				_vehicleBean = viewRecord(request);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(_vehicleBean != null) {
				request.setAttribute("vehicleBean", _vehicleBean);
				RequestDispatcher rd = request.getRequestDispatcher("displayRental.jsp");
				rd.forward(request, response);
			}
			else {			
				request.setAttribute("message","No matching records exists! Please try again!");
				RequestDispatcher rd = request.getRequestDispatcher("displayRental.jsp");
				rd.forward(request, response);
			}
		}
		else if(operation.equals("viewAllRecords")) {
			List<VehicleBean> records = viewAllRecords(request);
			if(records.isEmpty()) {
				request.setAttribute("message", "No records available!");
			}
			else {
				request.setAttribute("records", records);
			}

			RequestDispatcher rd = request.getRequestDispatcher("displayAllRentals.jsp");
			rd.forward(request, response);
		}
	}

}
