package com.trl.model.service;

import java.sql.SQLException;

import com.trl.model.bean.Customer;



public interface CustomerService {
	
	Customer save(Customer customer) ;
	Customer getCustomerNameByPhone(long phone);

}
