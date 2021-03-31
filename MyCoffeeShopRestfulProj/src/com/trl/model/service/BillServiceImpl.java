package com.trl.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.Bill;
import com.trl.model.dao.BillDao;
@Service
public class BillServiceImpl implements BillService {
   @Autowired
	private BillDao billDao ;
	
	public void setBillDao(BillDao billDao) {
		this.billDao = billDao;
	}


	@Override
	public Bill save(Bill bill) throws ClassNotFoundException, SQLException {
		
		return(billDao.save(bill));

	}

}
