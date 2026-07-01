package com.wipro.weather.servlets;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.wipro.weather.bean.WeatherBean;
import com.wipro.weather.service.Administrator;
import com.wipro.weather.util.InvalidInputException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	Administrator admin;
	
	public String addForecast(HttpServletRequest request) throws ParseException, InvalidInputException {
		admin = new Administrator();
		WeatherBean weatherBean = new WeatherBean();
		String location = request.getParameter("location");
		String str_date = request.getParameter("date");
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = format.parse(str_date);
		int temperature = Integer.parseInt(request.getParameter("temperature"));
		int humidity = Integer.parseInt(request.getParameter("humidity"));
		String wind = request.getParameter("wind");
		String forecast = request.getParameter("forecast");
		weatherBean.setLocation(location);
		weatherBean.setDate(new java.sql.Date(date.getTime()));
		weatherBean.setTemperature(temperature);
		weatherBean.setHumidity(humidity);
		weatherBean.setWind(wind);
		weatherBean.setForecast(forecast);
		return admin.addForecast(weatherBean);
		
	}
	
	
	public WeatherBean viewForecast(HttpServletRequest request) throws ParseException {
		admin = new Administrator();
		String location = request.getParameter("location");
		String str_date = request.getParameter("date");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(str_date);
		return admin.viewForecast(location, date);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("newForecast")) {
			try {
				String result = addForecast(request);
				if(result.equals("FAIL")) {
					response.sendRedirect("error.html");
				}
				else {
					response.sendRedirect("success.html");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (InvalidInputException e) {
				e.printStackTrace();
			}
			
		}
		else if(operation.equals("viewForecast")){
			WeatherBean weatherBean;
			try {
				weatherBean = viewForecast(request);

				if(weatherBean==null) {
					request.setAttribute("message","No matching records exists! Please try again!");
					RequestDispatcher rd = request.getRequestDispatcher("displayForecast.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("weatherBean", weatherBean);
					RequestDispatcher rd = request.getRequestDispatcher("displayForecast.jsp");
					rd.forward(request, response);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	}
}
