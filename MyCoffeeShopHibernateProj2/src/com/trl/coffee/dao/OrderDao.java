package com.trl.coffee.dao;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.coffee.bean.Orders;

public interface OrderDao {
	
     BigInteger save(Orders order) throws ClassNotFoundException,SQLException;

}
