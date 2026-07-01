package com.wipro.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.util.DBUtil;

public class ScheduleDAO {
	private Connection con;
	public ScheduleDAO() {
		try {
        con = DBUtil.getDBConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	public String createSchedule(ScheduleBean scheduleBean) throws SQLException {
		PreparedStatement ps = con.prepareStatement("Insert into SCHEDULE_TBL values(?,?,?,?,?)");
		ps.setString(1, scheduleBean.getScheduleId());
		ps.setString(2, scheduleBean.getSource());
		ps.setString(3, scheduleBean.getDestination());
		ps.setString(4, scheduleBean.getStartTime());
		ps.setString(5, scheduleBean.getArrivalTime());
		int rows = ps.executeUpdate();
		if(rows == 1) {
			return "SUCCESS";
		}
		return "FAIL";
	}
	
	public String generateID(String source,String destination) throws SQLException {
		String id= "";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select SCHEDULE_SEQ.nextval from dual");
		while(rs.next()) {
			id = rs.getString(1); 
		}
		String scheduleId = (source.substring(0,2) + destination.substring(0,2)).toUpperCase()+id;
		return scheduleId;
	}
	
	public ArrayList<ScheduleBean> viewSchedule (String source, String destination) throws SQLException{
		ArrayList <ScheduleBean> res = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("Select * from SCHEDULE_TBL where source = ? and destination = ?");
		ps.setString(1,source);
		ps.setString(2,destination);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ScheduleBean sb= new ScheduleBean();
			sb.setScheduleId(rs.getString(1));
			sb.setSource(rs.getString(2));
			sb.setDestination(rs.getString(3));
			sb.setStartTime(rs.getString(4));
			sb.setArrivalTime(rs.getString(5));
			res.add(sb);
		}
		return res;
	}
}
