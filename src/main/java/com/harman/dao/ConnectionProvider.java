package com.harman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
 // 3.03.15
	private static ConnectionProvider instance;
	private static Connection con;
	private static final String DRIVER = "com.sql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/harmandb" ;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
//	private ConnectionProvider() throws SQLException {
//		try {
//			Class.forName(DRIVER);
//			con = DriverManager.getConnection(URL, USERNAME , PASSWORD);
//		} catch(ClassNotFoundException exp) {
//			System.err.println(exp.getMessage());
//		}
//	}
//	
//	public static Connection getConnection() {
//		return con;
//	}
//	
//	public static ConnectionProvider getInstance() throws SQLException {
//		if(instance == null) {
//			instance = new ConnectionProvider();
//		}else if (getConnection().isClosed()) {
//			instance = new ConnectionProvider();
//		}
//		return instance;
//	}
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(URL , USERNAME, PASSWORD);
	}

}
