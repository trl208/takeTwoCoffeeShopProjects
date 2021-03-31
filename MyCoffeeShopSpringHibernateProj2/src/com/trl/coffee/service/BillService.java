package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Bill;


public interface BillService {
	void save(Bill bill) throws ClassNotFoundException,SQLException;

}
