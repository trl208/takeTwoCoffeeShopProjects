package com.trl.model.dao;

import java.sql.SQLException;

import com.trl.model.bean.Voucher;

public interface VoucherDao {
	
	 int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException;

}
