package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.util.ConnectionManager;

public class CoffeeDaoImpl implements CoffeeDao {

	@Override
	public ArrayList<Coffee> getAllCoffeeRecords() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		ArrayList<Coffee> coffeeList = new ArrayList<>();

		connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM BEVERAGE");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

			Coffee coffee = new Coffee();
			coffee.setcId(resultSet.getInt("beverage_id"));
			coffee.setcType(resultSet.getString("beverage_name"));
			coffee.setcSize(resultSet.getString("beverage_size"));
			coffee.setcPrice(resultSet.getInt("beverage_price"));
			

			coffeeList.add(coffee);
		}
		connection.close();
		return coffeeList;
	//	return null;
	}

}
