package com.trl.coffee.presentation;

import java.sql.SQLException;

import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.service.OrderDetailsService;
import com.trl.coffee.service.OrderDetailsServiceImpl;

public class OrderDetailsPresentationImpl implements OrderDetailsPresentation {
	
	private OrderDetailsService orderDetailsService=new OrderDetailsServiceImpl();

	
	@Override
	public void saveOrderDetails(OrderDetail orderDetails) {
		
		try {
			orderDetailsService.save(orderDetails);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}


	
}
