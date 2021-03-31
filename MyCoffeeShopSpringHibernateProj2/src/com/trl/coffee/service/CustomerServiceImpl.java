package com.trl.coffee.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.coffee.bean.Customer;
import com.trl.coffee.dao.CustomerDao;
import com.trl.coffee.dao.CustomerDaoImpl;
import com.trl.coffee.dao.OrderDetailsDao;
import com.trl.coffee.dao.OrderDetailsDaoImpl;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao ;
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) throws ClassNotFoundException, SQLException {
	 
		customerDao.save(customer);

	}

	@Override
	public String getCustomerNameByPhone(long phone) throws ClassNotFoundException, SQLException {
		return customerDao.getCustomerNameByPhone(phone);
		
	}

}
