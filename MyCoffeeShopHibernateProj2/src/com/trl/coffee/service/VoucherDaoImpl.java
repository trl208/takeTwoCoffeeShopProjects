package com.trl.coffee.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trl.coffee.bean.Voucher;
import com.trl.coffee.util.ConnectionManager;

public class VoucherDaoImpl implements VoucherDao {
	
	Connection connection = null;

	@Override
	public int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException {
	
		
		connection = ConnectionManager.getConnection("oracle.jdbc.driver.OracleDriver","jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
		
		System.out.println(" db connection established ..............");
		int voucherVal = 0;
		
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM vouchers WHERE vouchers_id=?");
		statement.setInt(1,voucher.getVoucherId());

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			voucherVal = resultSet.getInt("voucher_value");
			
			
		}
		connection.close(); // throwing check exception SQLException

		return voucherVal;
		
	}

}
