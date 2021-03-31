package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Customer;



public interface CustomerService {
	
	void save(Customer customer) throws ClassNotFoundException,SQLException;
	String getCustomerNameByPhone(long phone) throws ClassNotFoundException,SQLException;

}
