package com.trl.model.service;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.model.bean.Orders;

public interface OrderService {
	
	 Orders save(Orders order) throws ClassNotFoundException,SQLException;

}
