package com.trl.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.AddOn;
import com.trl.coffee.dao.AddOnDao;
import com.trl.coffee.dao.AddOnDaoImpl;
import com.trl.coffee.dao.CoffeeDao;
import com.trl.coffee.dao.CoffeeDaoImpl;

public class AddOnServiceImpl implements AddOnService {

	AddOnDao addOnDao = new AddOnDaoImpl();

	@Override
	public ArrayList<AddOn> getAllAddOns() throws ClassNotFoundException,SQLException {
		
		return addOnDao.getAllAddOns();
		//return null;
	} 

}
