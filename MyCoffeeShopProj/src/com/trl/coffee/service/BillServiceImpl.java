package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Bill;
import com.trl.coffee.dao.BillDao;
import com.trl.coffee.dao.BillDaoImpl;
import com.trl.coffee.dao.CustomerDao;
import com.trl.coffee.dao.CustomerDaoImpl;

public class BillServiceImpl implements BillService {

	private BillDao billDao = new BillDaoImpl();

	@Override
	public void save(Bill bill) throws ClassNotFoundException, SQLException {
		
		billDao.save(bill);

	}

}
