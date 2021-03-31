package com.trl.coffee.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trl.coffee.bean.Voucher;

@Repository
public class VoucherDaoImpl implements VoucherDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	@Override
	public int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException {

		// SessionFactory factory = ConnectionManager.getSessionFactory();
		// For every Transaction one Session object
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		String name = null;
		Voucher vouch = session.get(Voucher.class, voucher.getVoucherId());
		/*
		 * Query<Customer> query =
		 * session.createQuery("from Customer where custPhone=:phone");
		 * query.setParameter(phone, phone); name=
		 * query.getResultList().get(0).getName();
		 */

		// System.out.println("===========");

		transaction.commit();

		session.close();
		// factory.close();

		return vouch.getVoucherValue();

	}
}
