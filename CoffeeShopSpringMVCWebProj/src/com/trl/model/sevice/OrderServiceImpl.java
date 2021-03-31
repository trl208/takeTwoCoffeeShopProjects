package com.trl.model.sevice;

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



	public BigInteger save(Orders order) throws ClassNotFoundException,SQLException {
		 BigInteger orderId = orderDao.save(order);
	
		 return orderId;
	}
	
}
