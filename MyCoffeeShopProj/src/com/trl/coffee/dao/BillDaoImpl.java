package com.trl.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.trl.coffee.bean.Bill;
import com.trl.coffee.util.ConnectionManager;

public class BillDaoImpl implements BillDao {
	Connection connection=null;
	@Override
	public void save(Bill bill) {
		
		try{
					
			connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
			//2. Query
					
			PreparedStatement statement=connection.prepareStatement("INSERT INTO BILL VALUES(auto_num1.nextval,?,?,?)");
			
		//	statement.setInt(1, bill.getBillId());
			statement.setInt(1, bill.getOrderId());
			statement.setInt(2, bill.getBillValue());
			statement.setInt(3, bill.getVoucherId());
				
		

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
	public void saveOrUpdate(Bill bill) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bill bill) {
		// TODO Auto-generated method stub

	}

}
