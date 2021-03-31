
package com.trl.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.AddOn;

public interface AddOnService {

	ArrayList<AddOn> getAllAddOns() throws ClassNotFoundException,SQLException;
	
}
