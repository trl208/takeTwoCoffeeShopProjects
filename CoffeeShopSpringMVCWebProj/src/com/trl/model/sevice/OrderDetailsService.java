package com.trl.model.sevice;

import java.sql.SQLException;

import com.trl.model.bean.OrderDetail;

public interface OrderDetailsService {
	

	void save(OrderDetail order) throws ClassNotFoundException,SQLException;
	/*
	 * void saveOrUpdate(OrderDetail order) throws
	 * ClassNotFoundException,SQLException; void delete(OrderDetail order) throws
	 * ClassNotFoundException,SQLException;
	 */
	
	
	
	public OrderDetail convertUpperCase(OrderDetail orderDetail);

}
