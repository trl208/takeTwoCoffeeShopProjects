package com.trl.model.dao;

import java.sql.SQLException;

import com.trl.model.bean.Voucher;

public interface VoucherDao {
	
	 Voucher getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException;

}
