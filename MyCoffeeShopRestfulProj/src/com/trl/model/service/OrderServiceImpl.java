package com.trl.model.service;

import java.math.BigInteger;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.Orders;
import com.trl.model.dao.OrderDao;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	 public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}



	public Orders save(Orders order) throws ClassNotFoundException,SQLException {
		Orders order1 = orderDao.save(order);
	
		 return order1;
	}
	
}
