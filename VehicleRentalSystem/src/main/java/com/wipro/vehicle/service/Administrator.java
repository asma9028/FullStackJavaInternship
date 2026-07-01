package com.wipro.vehicle.service;

import java.util.Date;
import java.util.List;

import com.wipro.vehicle.bean.VehicleBean;
import com.wipro.vehicle.dao.VehicleDAO;
import com.wipro.vehicle.util.InvalidInputException;

public class Administrator {
	VehicleDAO dao=null;
	public String addRecord(VehicleBean vehicleBean) throws InvalidInputException {
		if(vehicleBean.getCustomerName()!=null && vehicleBean.getRentalDate() != null) {
			if(vehicleBean.getCustomerName().length()>=2) {
				if(vehicleBean.getRentalDate().before(new java.sql.Date(System.currentTimeMillis()))) {
					dao=new VehicleDAO();
					Boolean isPresent = dao.recordExists(vehicleBean.getCustomerName(), vehicleBean.getRentalDate());
					if(!isPresent) {
						String recordId = dao.generateRecordID(vehicleBean.getCustomerName(), vehicleBean.getRentalDate());
						vehicleBean.setRecordId(recordId);
						return dao.createRecord(vehicleBean);
					}
					else {
						return "ALREADY EXISTS";
					}
				}
				else {
					throw new InvalidInputException("INVALID DATE");
				}
			}
			else {
				throw new InvalidInputException("INVALID CUSTOMER NAME");
			}
		}
		else{
			throw new InvalidInputException("INVALID INPUT");
		}
	}
	
	public VehicleBean viewRecord(String customerName, Date rentalDate) {
		dao = new VehicleDAO();
		VehicleBean _vehicleBean = dao.fetchRecord(customerName, rentalDate);
		return _vehicleBean;
	}
	
	public List<VehicleBean> viewAllRecords(){
		dao=new VehicleDAO();
		List<VehicleBean> records = dao.fetchAllRecords();
		return records;
	}
}
