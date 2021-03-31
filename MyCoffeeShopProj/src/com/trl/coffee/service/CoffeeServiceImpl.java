package com.trl.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.dao.CoffeeDao;
import com.trl.coffee.dao.CoffeeDaoImpl;

public class CoffeeServiceImpl implements CoffeeService {
	
	CoffeeDao coffeeDao = new CoffeeDaoImpl();

	@Override
	public ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException, SQLException {
		return coffeeDao.getAllCoffeeRecords();
		}

}
