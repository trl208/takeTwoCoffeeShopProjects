package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trl.coffee.bean.Order;
import com.trl.coffee.util.ConnectionManager;

public class OrderDaoImpl implements OrderDao {
	Connection connection=null;
	@Override
	public int save(Order order) throws ClassNotFoundException, SQLException {
		int orderId = 0;
		try{
					
			connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
			
			//System.out.println(" db connection established ..............");
			
			String sqlIdentifier = "select auto_num1.nextval from dual";
			PreparedStatement pst = connection.prepareStatement(sqlIdentifier);
			
			   ResultSet rs = pst.executeQuery();
			   if(rs.next())
			      orderId = rs.getInt(1);
			//2. Query
					
			PreparedStatement statement=connection.prepareStatement("INSERT INTO ORDERS VALUES(?,?,SYSDATE)");
			
			//statement.setInt(1, order.getDetailId());
			statement.setInt(1, orderId);
			statement.setLong(2, order.getCustPhone());
					

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
		return orderId;
		
	}

}
