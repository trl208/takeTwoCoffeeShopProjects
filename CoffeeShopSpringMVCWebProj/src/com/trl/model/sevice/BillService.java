package com.trl.model.sevice;

import java.sql.SQLException;

import com.trl.model.bean.Bill;


public interface BillService {
	void save(Bill bill) throws ClassNotFoundException,SQLException;

}
