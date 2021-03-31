package com.trl.model.dao;


import com.trl.model.bean.Customer;

public interface CustomerDao {
	
	void save(Customer customer) ;
	void saveOrUpdate(Customer customer);
	void delete(Customer customer);
	String getCustomerNameByPhone(long phone) ;

}
