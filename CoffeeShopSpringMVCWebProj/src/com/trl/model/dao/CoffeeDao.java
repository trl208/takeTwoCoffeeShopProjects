package com.trl.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.model.bean.Coffee;

public interface CoffeeDao {
	
	ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException,SQLException;

}
