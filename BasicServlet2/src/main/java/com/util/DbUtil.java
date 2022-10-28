package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	static final String DB_URL = "jdbc:mysql://localhost:3306/testing";
	 static final String USER = "root";
	 static final String PASS = "root";
	 
	 public static Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn=DriverManager.getConnection(DB_URL,USER,PASS);  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
