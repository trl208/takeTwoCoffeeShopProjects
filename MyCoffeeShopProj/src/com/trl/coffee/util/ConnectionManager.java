package com.trl.coffee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	static private Connection connection;


public static Connection getConnection(String driverName,String url,String username,String password)throws ClassNotFoundException,SQLException{
	Class.forName(driverName);
	connection = DriverManager.getConnection(url,username,password); 
	return connection;
	}
}