package com.trl.coffee.presentation;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.service.OrderDetailsService;
import com.trl.coffee.service.OrderDetailsServiceImpl;

@Component("odpi")
public class OrderDetailsPresentationImpl implements OrderDetailsPresentation {
	@Autowired
	private OrderDetailsService orderDetailsService;
    	
	public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}


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
