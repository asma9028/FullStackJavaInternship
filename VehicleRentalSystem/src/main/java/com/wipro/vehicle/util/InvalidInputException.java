package com.wipro.vehicle.util;

public class InvalidInputException extends Exception{
	String msg = "Invalid Input";
	public InvalidInputException(String msg) {
		this.msg = msg;
	}
	public String toString() {
		return msg;
	}
}
