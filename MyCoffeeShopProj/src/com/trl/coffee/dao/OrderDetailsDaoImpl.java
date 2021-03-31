package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.util.ConnectionManager;

public class OrderDetailsDaoImpl implements OrderDetailsDao {
	Connection connection=null;
	@Override
	public void save(OrderDetail order) throws ClassNotFoundException, SQLException{
		
		try{
					
			connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
			
			//System.out.println(" db connection established ..............");
			//2. Query
					
			PreparedStatement statement=connection.prepareStatement("INSERT INTO ORDER_DETAILS VALUES(auto_num1.nextval,?,?,?)");
			
			//statement.setInt(1, order.getDetailId());
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getBeverageId());
			statement.setInt(3, order.getAddonId());
				
		

			int rows=statement.executeUpdate();  //for DML Operation we have executeUpdate
			//3.Process Results
			/*
			 * if(rows>0) System.out.println("Record Inserted"); else
			 * System.out.println("Record Not Inserted");
			 */
		}
		catch(ClassNotFoundException|SQLException ex){
			ex.printStackTrace();
		}
		finally{
			try {
				//4. Close Connection
				connection.close();   //throwing check exception SQLException
			} catch (SQLException e) {
				e.printStackTrace();
			}  
		}
		
	}

	@Override
	public void saveOrUpdate(OrderDetail order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(OrderDetail order) {
		// TODO Auto-generated method stub

	}

}
