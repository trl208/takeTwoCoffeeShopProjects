package com.trl.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.model.bean.Coffee;
import com.trl.model.bean.Coffees;

public interface CoffeeService {
	
	Coffees getAllCoffeeRecords() throws ClassNotFoundException,SQLException;

}
