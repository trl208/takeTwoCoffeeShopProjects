package com.trl.coffee.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.coffee.bean.Bill;
import com.trl.coffee.dao.BillDao;
import com.trl.coffee.dao.BillDaoImpl;
import com.trl.coffee.dao.CustomerDao;
import com.trl.coffee.dao.CustomerDaoImpl;
@Service
public class BillServiceImpl implements BillService {
    @Autowired
	private BillDao billDao ;
	
	public void setBillDao(BillDao billDao) {
		this.billDao = billDao;
	}


	@Override
	public void save(Bill bill) throws ClassNotFoundException, SQLException {
		
		billDao.save(bill);

	}

}
