package com.trl.model.sevice;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.trl.model.bean.Customer;


@Service
public interface CustomerService {
	
	void save(Customer customer) throws ClassNotFoundException,SQLException;
	Customer getCustomerNameByPhone(long phone) throws ClassNotFoundException,SQLException;

}
