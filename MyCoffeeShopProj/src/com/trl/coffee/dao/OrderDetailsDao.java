package com.trl.coffee.dao;

import java.sql.SQLException;

import com.trl.coffee.bean.OrderDetail;

public interface OrderDetailsDao {
	
	void save(OrderDetail order) throws ClassNotFoundException, SQLException;
	void saveOrUpdate(OrderDetail order);
	void delete(OrderDetail order);

}
