package com.wipro.bus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;
	
	public static Connection getDBConnection() {
		if(con==null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","asma","asma@2006");
				System.out.println("connected");
			}
			catch(ClassNotFoundException e) {
				System.out.println(e);
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		}
		return con;
	}
}
