package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Order;
import com.trl.coffee.dao.OrderDao;
import com.trl.coffee.dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao = new OrderDaoImpl();

	 public int save(Order order) throws ClassNotFoundException,SQLException {
		 int orderId = orderDao.save(order);
	
		 return orderId;
	}
	
}
