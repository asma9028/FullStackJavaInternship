package com.wipro.bus.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;
import com.wipro.bus.service.Administrator;
import com.wipro.bus.util.InvalidInputException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	Administrator admin = new Administrator();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");

		
		if(operation.equals("newSchedule")) {
			try {
				String res = addSchedule(request);
				if(res.equals("SUCCESS")) {
					response.sendRedirect("success.jsp");
				}
				else {
					response.sendRedirect("errorInserting.html");
				}
			} catch (InvalidInputException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(operation.equals("viewSchedule")) {
			try {
				ArrayList<ScheduleBean> res = viewSchedule(request);
				if(res.equals(null)) {
					response.sendRedirect("displaySchedule.jsp");
				}
				else {
					request.setAttribute("schedules", res);
					RequestDispatcher rd = request.getRequestDispatcher("displaySchedule.jsp");
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addSchedule(HttpServletRequest request) throws InvalidInputException, SQLException {
		ScheduleBean sb = new ScheduleBean();
		sb.setScheduleId(request.getParameter("scheduleId"));
		sb.setSource(request.getParameter("source"));
		sb.setDestination(request.getParameter("destination"));
		sb.setStartTime(request.getParameter("startTime"));
		sb.setArrivalTime(request.getParameter("arrivalTime"));
		String res = admin.addSchedule(sb);
		return res;
	}
	
	public ArrayList <ScheduleBean> viewSchedule(HttpServletRequest request) throws SQLException{
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		ArrayList<ScheduleBean> res = admin.viewSchedule(source, destination);
		return res;
	}

}
