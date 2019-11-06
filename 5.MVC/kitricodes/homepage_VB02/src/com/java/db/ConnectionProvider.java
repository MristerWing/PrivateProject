package com.java.db;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn = null;
		
		// server context
		try {
			Context initContext = new InitialContext();
			
			// 접두어(resource)
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			
			// mvcDb in resource
			DataSource ds = (DataSource) envContext.lookup("jdbc/mvcDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
