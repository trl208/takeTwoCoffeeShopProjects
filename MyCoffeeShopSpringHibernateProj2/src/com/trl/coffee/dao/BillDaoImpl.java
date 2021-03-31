package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trl.coffee.bean.Bill;
import com.trl.coffee.bean.Coffee;
import com.trl.coffee.util.ConnectionManager;

@Repository
public class BillDaoImpl implements BillDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */
	
	@Override
	public void save(Bill bill) {

		// SessionFactory factory = ConnectionManager.getSessionFactory();
		// For every Transaction one Session object
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(bill);
		// System.out.println("=========== bill saved");

		transaction.commit();

		session.close();
		// factory.close();

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
