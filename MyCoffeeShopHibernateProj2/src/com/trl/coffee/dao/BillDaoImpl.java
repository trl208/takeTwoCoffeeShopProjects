package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trl.coffee.bean.Bill;
import com.trl.coffee.bean.Coffee;
import com.trl.coffee.util.ConnectionManager;

public class BillDaoImpl implements BillDao {
	Connection connection=null;
	@Override
	public void save(Bill bill) {
		
		SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		  session.save(bill);		 
	//	System.out.println("=========== bill saved");
		
		transaction.commit();
		
		session.close();
		factory.close();
		
		}

	@Override
	public void saveOrUpdate(Bill bill) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bill bill) {
		// TODO Auto-generated method stub

	}

}
