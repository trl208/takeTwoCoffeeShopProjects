package com.trl.model.sevice;

import java.math.BigInteger;
import java.sql.SQLException;

import com.trl.model.bean.Orders;

public interface OrderService {
	
	 BigInteger save(Orders order) throws ClassNotFoundException,SQLException;

}
