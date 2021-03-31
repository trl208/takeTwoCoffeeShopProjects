package com.trl.model.sevice;

import java.sql.SQLException;

import com.trl.model.bean.Voucher;

public interface VoucherService {
	
	int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException;

}
