package com.wipro.vehicle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.vehicle.bean.VehicleBean;
import com.wipro.vehicle.util.DBUtil;

public class VehicleDAO {
	private static Connection con;
	public String createRecord(VehicleBean vehicleBean) {
		try {
			con = DBUtil.getDBConnection();
			String query = "Insert into vehicle_rental_tb values (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			String recordId = generateRecordID(vehicleBean.getCustomerName(),vehicleBean.getRentalDate());
			ps.setString(1,recordId);
			ps.setString(2, vehicleBean.getCustomerName());
			ps.setString(3, vehicleBean.getVehicleType());
			ps.setDate(4, new java.sql.Date(vehicleBean.getRentalDate().getTime()));
			ps.setDate(5, new java.sql.Date(vehicleBean.getReturnDate().getTime()));
			ps.setInt(6, vehicleBean.getAmount());
			ps.setString(7,vehicleBean.getRemarks());
			int rows = ps.executeUpdate();
			if(rows == 1) {
				return recordId;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	public VehicleBean fetchRecord(String customerName, Date rentalDate) {
		try {
			con = DBUtil.getDBConnection();
			String query = "Select * from vehicle_rental_tb where customername=? and rentaldate=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerName);
			ps.setDate(2, new java.sql.Date(rentalDate.getTime()));
			System.out.println("Searching for:");
			System.out.println("Customer = " + customerName);
			System.out.println("Rental Date = " + new java.sql.Date(rentalDate.getTime()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				VehicleBean _vehicleBean = new VehicleBean();
				String recordId = rs.getString(1);
				String vehicleType = rs.getString(3);
				Date returnDate = rs.getDate(5);
				int amount = rs.getInt(6);
				String remarks = rs.getString(7);
				_vehicleBean.setRecordId(recordId);
				_vehicleBean.setCustomerName(customerName);
				_vehicleBean.setVehicleType(vehicleType);
				_vehicleBean.setRentalDate(rentalDate);
				_vehicleBean.setReturnDate(returnDate);
				_vehicleBean.setAmount(amount);
				_vehicleBean.setRemarks(remarks);
				return _vehicleBean;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String generateRecordID(String customerName, Date rentalDate) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String temp = format.format(rentalDate);
		temp += customerName.substring(0,2).toUpperCase();
		String query = "Select vehicle_rental_seq.NEXTVAL from dual";
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			String seq = String.valueOf(rs.getInt(1));
			temp += seq;
			}
			return temp;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean recordExists(String customerName, Date rentalDate) {
		VehicleBean _vehicleBean = fetchRecord(customerName,rentalDate);
		if(_vehicleBean != null) {
			return true;
		}
		return false;
	}
	
	public List<VehicleBean> fetchAllRecords(){
		List<VehicleBean> records = new ArrayList<>();
		String query = "Select * from vehicle_rental_tb";
		try {
			con = DBUtil.getDBConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				VehicleBean _vehicleBean = new VehicleBean();
				String recordId = rs.getString(1);
				String customerName = rs.getString(2);
				String vehicleType = rs.getString(3);
				Date rentalDate = rs.getDate(4);
				Date returnDate = rs.getDate(5);
				int amount = rs.getInt(6);
				String remarks = rs.getString(7);
				_vehicleBean.setRecordId(recordId);
				_vehicleBean.setCustomerName(customerName);
				_vehicleBean.setVehicleType(vehicleType);
				_vehicleBean.setRentalDate(rentalDate);
				_vehicleBean.setReturnDate(returnDate);
				_vehicleBean.setAmount(amount);
				_vehicleBean.setRemarks(remarks);
				records.add(_vehicleBean);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return records;
	}
}
