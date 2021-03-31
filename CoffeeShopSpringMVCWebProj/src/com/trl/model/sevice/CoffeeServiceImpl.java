package com.trl.model.sevice;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.Coffee;
import com.trl.model.dao.CoffeeDao;
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
