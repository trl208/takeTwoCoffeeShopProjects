package com.trl.coffee.presentation;

import java.sql.SQLException;

import com.trl.coffee.bean.Order;
import com.trl.coffee.service.OrderService;
import com.trl.coffee.service.OrderServiceImpl;

public class OrderPresentImpl implements OrderPresent {
    OrderService orderService =new OrderServiceImpl();
	@Override
	public int generateOrder(Order order) {
		int id =0;
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
