package com.calendar.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "wing";
			String pwd = "eternal";
			
			connection = DriverManager.getConnection(url, id, pwd);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return connection;
	}
	
}
