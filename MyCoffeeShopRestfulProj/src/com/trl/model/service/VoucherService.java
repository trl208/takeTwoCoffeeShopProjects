package com.trl.model.service;

import java.sql.SQLException;

import com.trl.model.bean.Voucher;

public interface VoucherService {
	
	Voucher getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException;

}
