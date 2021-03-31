package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.util.ConnectionManager;

@Repository
public class CoffeeDaoImpl implements CoffeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */
	@Override
	public ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException, SQLException {

		ArrayList<Coffee> coffeeList = new ArrayList<>();

		// SessionFactory factory = ConnectionManager.getSessionFactory();
		// For every Transaction one Session object
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Query<Coffee> query = session.createQuery("from Coffee");
		coffeeList = (ArrayList<Coffee>) query.getResultList();
		coffeeList.stream().forEach(System.out::println);

		// System.out.println("===========");

		transaction.commit();

		session.close();
		// factory.close();

		return coffeeList;
		// return null;
	}

}
