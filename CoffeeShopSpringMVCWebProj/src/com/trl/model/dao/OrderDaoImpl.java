package com.trl.model.dao;

import java.math.BigInteger;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trl.model.bean.Orders;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 * 
	 * Connection connection = null;
	 */
	@Override
	public BigInteger save(Orders order) throws ClassNotFoundException, SQLException {
		// BigInteger orderId = new BigInteger(" ");

		/// SessionFactory factory = ConnectionManager.getSessionFactory();
		// For every Transaction one Session object
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// Query query = session.createSQLQuery("select auto_num1.nextval as num from
		// dual").addScalar("num", StandardBasicTypes.BIG_INTEGER);
		// session.createSQLQuery("select MYSEQ.nextval as num from dual")

		//
		// query.setParameter(1, phone);
		// BigInteger orderId= (BigInteger) query.getResultList().get(0);

		// order.setOrderId(orderId);
		BigInteger orderId = (BigInteger) session.save(order);
		// System.out.println("=========== order saved" + orderId);

		transaction.commit();

		session.close();
		// factory.close();

		return orderId;

	}

}
