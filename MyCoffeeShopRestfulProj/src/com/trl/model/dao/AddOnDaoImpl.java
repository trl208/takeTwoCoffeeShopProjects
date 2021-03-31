package com.trl.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.trl.model.bean.AddOn;
@Repository
public class AddOnDaoImpl implements AddOnDao {

	@Autowired
   private SessionFactory sessionFactory;
	/*
	 * public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */
	
	@Override
	public ArrayList<AddOn> getAllAddOns()  {
		
		ArrayList<AddOn> addOnList = new ArrayList<>();
		//SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		
		Session session= sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
	   //   TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
		 @SuppressWarnings("unchecked")
		  Query<AddOn> query = session.createQuery("from AddOn");
		  addOnList = (ArrayList<AddOn>) query.getResultList();
		  addOnList.stream().forEach(System.out::println);
		 
	//	System.out.println("===========");
		
		transaction.commit();
		
		//session.close();
		//factory.close();
		return addOnList;
	//	return null;
	}

}
