package com.trl.resource;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.Orders;
import com.trl.model.service.OrderService;

@RestController
public class OrdersJsonResource {
	
	private OrderService orderService;
	
	@PostMapping(path = "/json/orders", produces = "application/json", consumes ="application/json" )
	public Orders saveOrder(@RequestBody Orders order) {
		try {
			 orderService.save(order);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	

}
