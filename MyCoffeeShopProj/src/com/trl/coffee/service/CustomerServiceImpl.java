package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Customer;
import com.trl.coffee.dao.CustomerDao;
import com.trl.coffee.dao.CustomerDaoImpl;
import com.trl.coffee.dao.OrderDetailsDao;
import com.trl.coffee.dao.OrderDetailsDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao = new CustomerDaoImpl();

	@Override
	public void save(Customer customer) throws ClassNotFoundException, SQLException {
	 
		customerDao.save(customer);

	}

	@Override
	public String getCustomerNameByPhone(long phone) throws ClassNotFoundException, SQLException {
		return customerDao.getCustomerNameByPhone(phone);
		
	}

}
