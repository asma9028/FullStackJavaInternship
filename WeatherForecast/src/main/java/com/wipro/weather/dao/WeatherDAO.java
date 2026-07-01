package com.wipro.weather.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.wipro.weather.bean.WeatherBean;
import com.wipro.weather.util.DBUtil;

public class WeatherDAO {
	private Connection con = null;
	private WeatherBean weatherBean = null;
	public String createForecast(WeatherBean weatherBean) {
		try {
		con = DBUtil.getDBConnection();
		String query = "Insert into WEATHER_TB values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, weatherBean.getReportId());
		ps.setString(2, weatherBean.getLocation());
		ps.setDate(3, weatherBean.getDate());
		ps.setInt(4, weatherBean.getTemperature());
		ps.setInt(5, weatherBean.getHumidity());
		ps.setString(6, weatherBean.getWind());
		ps.setString(7, weatherBean.getForecast());
		int rows = ps.executeUpdate();
		if(rows == 1) {
			return weatherBean.getReportId();
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	public WeatherBean fetchForecast(String location, Date date) {
		String query = "Select * from WEATHER_TB where location=? and \"date\"=?";
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, location);
			ps.setDate(2, new java.sql.Date(date.getTime()));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				weatherBean = new WeatherBean();
				weatherBean.setReportId(rs.getString(1));
				weatherBean.setLocation(rs.getString(2));
				weatherBean.setDate(rs.getDate(3));
				weatherBean.setHumidity(rs.getInt(4));
				weatherBean.setTemperature(rs.getInt(5));
				weatherBean.setWind(rs.getString(6));
				weatherBean.setForecast(rs.getString(7));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return weatherBean;
	}
	
	public String generateReportID(String location,Date date) {
		String temp = "";
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		temp = format.format(date);
		temp += location.substring(0,2).toUpperCase();
		String query = "Select WEATHER_SEQ.NEXTVAL from dual";
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int seq = rs.getInt(1);
				temp += String.valueOf(seq);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public boolean reportExists(String location, Date date) {
		weatherBean = fetchForecast(location, date);
		if(weatherBean == null) {
			return false;
		}
		return true;
	}

}
