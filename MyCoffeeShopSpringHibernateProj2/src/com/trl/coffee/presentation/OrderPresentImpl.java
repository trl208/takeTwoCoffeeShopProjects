package com.trl.coffee.presentation;

import java.math.BigInteger;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trl.coffee.bean.Orders;
import com.trl.coffee.service.OrderService;
import com.trl.coffee.service.OrderServiceImpl;
@Component("orderPresentation")
public class OrderPresentImpl implements OrderPresent {
	
	@Autowired
    OrderService orderService ;
    
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

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
