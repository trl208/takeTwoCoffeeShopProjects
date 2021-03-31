package com.trl.coffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.AddOn;

public interface AddOnDao {
	
	ArrayList<AddOn> getAllAddOns() throws ClassNotFoundException,SQLException;

}
