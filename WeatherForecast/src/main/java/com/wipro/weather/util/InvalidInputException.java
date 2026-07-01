package com.wipro.weather.util;

public class InvalidInputException extends Exception{
	String msg = "Input";
	public InvalidInputException() {super();};
	public  InvalidInputException(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Invalid "+msg;
	}
}
