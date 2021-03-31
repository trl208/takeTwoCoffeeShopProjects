package com.trl.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.dao.CoffeeDao;
import com.trl.coffee.dao.CoffeeDaoImpl;
@Service
public class CoffeeServiceImpl implements CoffeeService {
	@Autowired
	CoffeeDao coffeeDao ;
	
	public void setCoffeeDao(CoffeeDao coffeeDao) {
		this.coffeeDao = coffeeDao;
	}



	@Override
	public ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException, SQLException {
		return coffeeDao.getAllCoffeeRecords();
		}

}
