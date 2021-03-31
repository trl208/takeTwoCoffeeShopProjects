package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.util.ConnectionManager;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
	Connection connection=null;
	@Override
	public void save(OrderDetail order) throws ClassNotFoundException, SQLException{
		

		
		SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		  session.save(order);		 
	//	System.out.println("=========== order saved");
		
		transaction.commit();
		
		session.close();
		factory.close();
				
	}

	@Override
	public void saveOrUpdate(OrderDetail order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(OrderDetail order) {
		// TODO Auto-generated method stub

	}

}
