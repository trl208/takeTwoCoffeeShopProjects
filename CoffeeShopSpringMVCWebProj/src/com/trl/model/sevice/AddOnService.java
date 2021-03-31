
package com.trl.model.sevice;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.model.bean.AddOn;

public interface AddOnService {

	ArrayList<AddOn> getAllAddOns() throws ClassNotFoundException,SQLException;
	
}
