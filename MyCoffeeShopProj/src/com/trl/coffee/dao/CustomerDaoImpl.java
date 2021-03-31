package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trl.coffee.bean.Customer;
import com.trl.coffee.util.ConnectionManager;

public class CustomerDaoImpl implements CustomerDao {
	Connection connection=null;
	@Override
	public void save(Customer customer) throws ClassNotFoundException, SQLException  {
		
	
					
			connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
			//2. Query
					
			PreparedStatement statement=connection.prepareStatement("INSERT INTO CUSTOMER VALUES(?,?)");
			//System.out.println("customer phone num b4 save ........:" + customer.getCustPhone());
			//System.out.println("customer name b4 save ........:" + customer.getName());
			statement.setString(1, customer.getName());
			statement.setLong(2, customer.getCustPhone());
			
			int rows=statement.executeUpdate();  //for DML Operation we have executeUpdate
			//3.Process Results
			/*
			 * if(rows>0) System.out.println("Record Inserted"); else
			 * System.out.println("Record Not Inserted");
			 */
				//4. Close Connection
				connection.close();   //throwing check exception SQLException
			
		}
		
	@Override
	public String getCustomerNameByPhone(long phone) throws ClassNotFoundException, SQLException {
		connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
		String name = null;
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CUST_PHONE =? ");
		statement.setLong(1, phone);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			name = resultSet.getString("NAME");
		}
		connection.close();
		
		return name;
	}

	@Override
	public void saveOrUpdate(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Customer customer) {
		// TODO Auto-generated method stub

	}

	

}
