package com.trl.coffee.service;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.coffee.bean.Orders;

public interface OrderService {
	
	 BigInteger save(Orders order) throws ClassNotFoundException,SQLException;

}
