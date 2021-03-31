package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Voucher;

public interface VoucherService {
	
	int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException;

}
