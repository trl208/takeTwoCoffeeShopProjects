package com.trl.model.service;

import java.sql.SQLException;

import com.trl.model.bean.Bill;


public interface BillService {
	Bill save(Bill bill) throws ClassNotFoundException,SQLException;

}
