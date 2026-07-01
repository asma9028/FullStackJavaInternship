package com.wipro.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con = null;
	public static Connection getDBConnection() {
		if(con == null) {
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","asma","asma@2006");
			System.out.println("Connected");
		}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
		return con;
	}
}
