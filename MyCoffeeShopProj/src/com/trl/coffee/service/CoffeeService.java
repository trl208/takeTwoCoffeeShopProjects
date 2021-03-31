package com.trl.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.Coffee;

public interface CoffeeService {
	
	ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException,SQLException;

}
