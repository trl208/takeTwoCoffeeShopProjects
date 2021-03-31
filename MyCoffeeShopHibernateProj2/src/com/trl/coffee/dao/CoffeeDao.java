package com.trl.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.Coffee;

public interface CoffeeDao {
	
	ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException,SQLException;

}
