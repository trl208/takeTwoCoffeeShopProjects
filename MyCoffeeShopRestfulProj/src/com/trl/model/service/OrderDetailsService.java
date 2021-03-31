package com.trl.model.service;

import java.sql.SQLException;

import com.trl.model.bean.OrderDetail;

public interface OrderDetailsService {
	

	OrderDetail save(OrderDetail order) throws ClassNotFoundException,SQLException;
	/*
	 * void saveOrUpdate(OrderDetail order) throws
	 * ClassNotFoundException,SQLException; void delete(OrderDetail order) throws
	 * ClassNotFoundException,SQLException;
	 */
	
	
	
	public OrderDetail convertUpperCase(OrderDetail orderDetail);

}
