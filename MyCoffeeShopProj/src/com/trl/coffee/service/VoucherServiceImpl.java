package com.trl.coffee.service;

import java.sql.SQLException;

import com.trl.coffee.bean.Voucher;

public class VoucherServiceImpl implements VoucherService {

	VoucherDao vdao = new VoucherDaoImpl();
	
	@Override 
	public int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException{
		
		return vdao.getVoucherValueByNumber(voucher);
		
		 
	}

}
