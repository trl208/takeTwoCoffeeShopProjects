package com.trl.model.dao;

import com.trl.model.bean.Bill;


public interface BillDao {
	
	Bill save(Bill bill);
	void saveOrUpdate(Bill bill);
	void delete(Bill bill);

}
