package com.trl.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.coffee.bean.AddOn;
import com.trl.coffee.dao.AddOnDao;
@Service
public class AddOnServiceImpl implements AddOnService {

	@Autowired
	private AddOnDao addOnDao;

	public void setAddOnDao(AddOnDao addOnDao) {
		this.addOnDao = addOnDao;
	}
	

	@Override
	public ArrayList<AddOn> getAllAddOns() throws ClassNotFoundException,SQLException {
		
		return addOnDao.getAllAddOns();
		//return null;
	} 

}
