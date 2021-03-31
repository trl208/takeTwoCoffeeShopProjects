package com.trl.coffee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConnectionManager {
	
	static private Connection connection;


public static Connection getConnection(String driverName,String url,String username,String password)throws ClassNotFoundException,SQLException{
	Class.forName(driverName);
	connection = DriverManager.getConnection(url,username,password); 
	return connection;
	}
public static SessionFactory getSessionFactory() {
	
	StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	
	Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

	//For entire application one SessionFactory object : SessionFactory is SingleTon
	SessionFactory factory=meta.getSessionFactoryBuilder().build();
	
	return factory;
}

}