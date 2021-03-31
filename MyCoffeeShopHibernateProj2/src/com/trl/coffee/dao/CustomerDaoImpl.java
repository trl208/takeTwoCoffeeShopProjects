package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.bean.Customer;
import com.trl.coffee.util.ConnectionManager;

public class CustomerDaoImpl implements CustomerDao {
	Connection connection=null;
	@Override
	public void save(Customer customer) throws ClassNotFoundException, SQLException  {
		
		SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		  session.save(customer);		 
		System.out.println("=========== customer saved");
		
		transaction.commit();
		
		session.close();
		factory.close();
					
		}
		
	@Override
	public String getCustomerNameByPhone(long phone) throws ClassNotFoundException, SQLException {
		
		
		SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		String name = null;
		Customer cust =  session.load(Customer.class, phone);
		/*
		 * Query<Customer> query =
		 * session.createQuery("from Customer where custPhone=:phone");
		 * query.setParameter(phone, phone); name=
		 * query.getResultList().get(0).getName();
		 */
		  
		//System.out.println("===========");
		
		transaction.commit();
		
		session.close();
		factory.close();
				
		return name;
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub

	}

	

}
