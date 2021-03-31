package com.trl.model.sevice;

import java.sql.SQLException;

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
	public void save(Customer customer) throws ClassNotFoundException, SQLException {
	 
		customerDao.save(customer);

	}

	@Override
	public Customer getCustomerNameByPhone(long phone) throws ClassNotFoundException, SQLException {
				
		String name = customerDao.getCustomerNameByPhone(phone);
		Customer customer = new Customer(phone,name);
		return customer;
		
	}

}
