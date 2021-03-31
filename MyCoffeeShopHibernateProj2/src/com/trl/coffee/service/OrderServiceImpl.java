package com.trl.coffee.service;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.coffee.bean.Orders;
import com.trl.coffee.dao.OrderDao;
import com.trl.coffee.dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao = new OrderDaoImpl();

	 public BigInteger save(Orders order) throws ClassNotFoundException,SQLException {
		 BigInteger orderId = orderDao.save(order);
	
		 return orderId;
	}
	
}
