package com.trl.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trl.model.bean.Bill;
@Repository
public class BillDaoImpl implements BillDao {
	@Autowired	
private SessionFactory sessionFactory;

/*
 * public void setSessionFactory(SessionFactory sessionFactory) {
 * this.sessionFactory = sessionFactory; }
 */	
	@Override
	public Bill save(Bill bill) {
		
		//SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		Session session=sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		  session.save(bill);		 
	//	System.out.println("=========== bill saved");
		
		transaction.commit();
		
		session.close();
	//	factory.close();
		return bill;
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
