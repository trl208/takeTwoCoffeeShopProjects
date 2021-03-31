package com.trl.resource;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.OrderDetail;
import com.trl.model.service.OrderDetailsService;

@RestController
public class OrderDetailJsonResource {
	
	@Autowired
	OrderDetailsService orderDetailsService;
	
	@PostMapping(path = "/json/orderDetails", produces = "application/json", consumes ="application/json" )
	public OrderDetail saveOrderDetails(@RequestBody OrderDetail orderDetails) {
		OrderDetail od = new OrderDetail();
		try {
			od = orderDetailsService.save(orderDetails);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return od;
	}

}
