package com.trl.coffee.presentation;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.coffee.bean.Orders;
import com.trl.coffee.service.OrderService;
import com.trl.coffee.service.OrderServiceImpl;

public class OrderPresentImpl implements OrderPresent {
    OrderService orderService =new OrderServiceImpl();
	@Override
	public BigInteger generateOrder(Orders order) {
		BigInteger id =null;
		try {
			id =  orderService.save(order);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
