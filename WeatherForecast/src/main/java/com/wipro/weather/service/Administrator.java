package com.wipro.weather.service;

import java.util.Date;

import com.wipro.weather.bean.WeatherBean;
import com.wipro.weather.dao.WeatherDAO;
import com.wipro.weather.util.InvalidInputException;

public class Administrator {
	WeatherDAO weatherdao = null;
	
	public String addForecast(WeatherBean weatherBean) throws InvalidInputException {
		weatherdao = new WeatherDAO();
		if(weatherBean !=null && weatherBean.getLocation()!=null && weatherBean.getDate()!=null) {
			if(weatherBean.getLocation().length()>2) {
				if(weatherBean.getDate().before(new Date())) {
					boolean isPresent = weatherdao.reportExists(weatherBean.getLocation(),weatherBean.getDate());
					if(isPresent) {
						return "ALREADY EXISTS";
					}else {
						String reportId = weatherdao.generateReportID(weatherBean.getLocation(), weatherBean.getDate());
						if(!reportId.equals("")) {
							weatherBean.setReportId(reportId);
							String status = weatherdao.createForecast(weatherBean);
							return status;
						}
					}
				}
				else {
					throw new InvalidInputException("Date");
				}
				
			}
			else {
				throw new InvalidInputException("Location");
			}
		}
		else {
			throw new InvalidInputException();
		}
		return null;
	}
	
	public WeatherBean viewForecast(String location, Date date) {
		weatherdao= new WeatherDAO();
		return weatherdao.fetchForecast(location, new java.sql.Date(date.getTime()));
	}
}
