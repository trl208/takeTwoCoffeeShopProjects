package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Order;

public interface OrderService {
	
	 int save(Order order) throws ClassNotFoundException,SQLException;

}
