package com.trl.model.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trl.model.bean.OrderDetail;

@Repository
public class OrderDetailsDaoImpl implements OrderDetailsDao {
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * Connection connection = null;
	 */

	@Override
	public void save(OrderDetail order) throws ClassNotFoundException, SQLException {

//		SessionFactory factory = ConnectionManager.getSessionFactory();
		// For every Transaction one Session object
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(order);
		// System.out.println("=========== order saved");

		transaction.commit();

		session.close();
		// factory.close();

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
