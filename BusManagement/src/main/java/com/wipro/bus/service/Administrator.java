package com.wipro.bus.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;
import com.wipro.bus.util.InvalidInputException;

public class Administrator {
	
	public String addSchedule(ScheduleBean scheduleBean) throws InvalidInputException, SQLException {
		if(scheduleBean == null) {
			throw new InvalidInputException();
		}
		else if(scheduleBean.getSource() == null || scheduleBean.getSource().equals("")) {
			throw new InvalidInputException();
		}
		else if(scheduleBean.getDestination()== null || scheduleBean.getDestination().equals("")){
			throw new InvalidInputException();
	}
		else if(scheduleBean.getSource().length()<2 || scheduleBean.getDestination().length()<2) {
			throw new InvalidInputException();
		}
		else if(scheduleBean.getSource().equals(scheduleBean.getDestination())){
			return "Source and Destination Same";
		}
		else {
			ScheduleDAO sd = new ScheduleDAO();
			ScheduleBean sb = new ScheduleBean();
			String id = sd.generateID(scheduleBean.getSource(), scheduleBean.getDestination());
			sb.setScheduleId(id);
			sb.setSource(scheduleBean.getSource());
			sb.setDestination(scheduleBean.getDestination());
			sb.setStartTime(scheduleBean.getStartTime());
			sb.setArrivalTime(scheduleBean.getArrivalTime());
			String res = sd.createSchedule(sb);
			return res;
		}
		}
	
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination) throws SQLException{
		ScheduleDAO sd = new ScheduleDAO();
		ArrayList<ScheduleBean> res =  sd.viewSchedule(source, destination);
		return res;
	}
	}
