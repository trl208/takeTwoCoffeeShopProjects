package com.trl.coffee.dao;

import java.sql.SQLException;

import com.trl.coffee.bean.Order;

public interface OrderDao {
	
     int save(Order order) throws ClassNotFoundException,SQLException;

}
