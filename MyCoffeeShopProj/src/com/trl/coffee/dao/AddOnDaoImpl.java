package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.AddOn;
import com.trl.coffee.bean.Coffee;
import com.trl.coffee.util.ConnectionManager;

public class AddOnDaoImpl implements AddOnDao {

	@Override
	public ArrayList<AddOn> getAllAddOns() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		ArrayList<AddOn> addOnList = new ArrayList<>();

		connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ADDONS");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

			AddOn addOn = new AddOn();
			addOn.setAddOnId(resultSet.getInt("addon_id"));
			addOn.setAddOnName(resultSet.getString("addon_name"));
			addOn.setAddOnPrice(resultSet.getInt("addon_price"));
			
			

			addOnList.add(addOn);
		}
		connection.close();
		return addOnList;
	//	return null;
	}

}
