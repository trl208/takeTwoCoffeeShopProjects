package com.trl.coffee.presentation;

import java.math.BigInteger;

import com.trl.coffee.bean.Orders;

public interface OrderPresent {
	
	BigInteger generateOrder(Orders order);

}
