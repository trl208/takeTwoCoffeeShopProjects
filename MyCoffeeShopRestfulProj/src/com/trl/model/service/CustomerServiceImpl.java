package com.trl.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.Customer;
import com.trl.model.dao.CustomerDao;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao ;
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer save(Customer customer) {
	 
		customerDao.save(customer);
		return customer;

	}

	@Override
	public Customer getCustomerNameByPhone(long phone) {
		Customer cust = new Customer();
		cust.setCustPhone(phone);
		cust.setName(customerDao.getCustomerNameByPhone(phone));
		return cust ;
		
	}

}
