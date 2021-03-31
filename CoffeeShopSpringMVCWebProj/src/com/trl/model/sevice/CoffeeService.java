package com.trl.model.sevice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.model.bean.Coffee;

public interface CoffeeService {
	
	ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException,SQLException;

}
