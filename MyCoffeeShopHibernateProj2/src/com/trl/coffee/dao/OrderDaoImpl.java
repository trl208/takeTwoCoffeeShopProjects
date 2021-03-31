package com.trl.coffee.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.sql.SQLQueryParser;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import com.trl.coffee.bean.Orders;
import com.trl.coffee.util.ConnectionManager;

public class OrderDaoImpl implements OrderDao {
	Connection connection=null;
	@Override
	public BigInteger save(Orders order) throws ClassNotFoundException, SQLException {
	//	BigInteger orderId = new BigInteger(" ");

		
		SessionFactory factory = ConnectionManager.getSessionFactory();
		//For every Transaction one Session object
		Session session=factory.openSession();
		
		Transaction transaction=session.beginTransaction();
		
		//  Query query = session.createSQLQuery("select auto_num1.nextval as num from dual").addScalar("num", StandardBasicTypes.BIG_INTEGER);
		 // session.createSQLQuery("select MYSEQ.nextval as num from dual")
         
		  //
		  //query.setParameter(1, phone);
		  //BigInteger  orderId= (BigInteger) query.getResultList().get(0);
		 
			//	order.setOrderId(orderId);
		BigInteger orderId=  (BigInteger) session.save(order);		 
		//System.out.println("=========== order saved" + orderId);
		
		transaction.commit();
		
		session.close();
		factory.close();
				
		return orderId;
		
	}

}
