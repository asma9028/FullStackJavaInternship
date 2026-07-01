package com.wipro.payroll.util;

public class InvalidInputException extends Exception{
	private String msg = "INVALID INPUT";
	public InvalidInputException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}
