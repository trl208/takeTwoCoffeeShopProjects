package com.trl.coffee.dao;

import com.trl.coffee.bean.Bill;


public interface BillDao {
	
	void save(Bill bill);
	void saveOrUpdate(Bill bill);
	void delete(Bill bill);

}
