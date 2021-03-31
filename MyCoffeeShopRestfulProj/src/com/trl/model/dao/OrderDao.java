package com.trl.model.dao;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.model.bean.Orders;

public interface OrderDao {
	
     Orders save(Orders order) throws ClassNotFoundException,SQLException;

}
