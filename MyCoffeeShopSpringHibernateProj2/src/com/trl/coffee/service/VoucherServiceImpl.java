package com.trl.coffee.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.coffee.bean.Voucher;
import com.trl.coffee.dao.VoucherDao;
import com.trl.coffee.dao.VoucherDaoImpl;
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
	VoucherDao vdao;
	
	public void setVdao(VoucherDao vdao) {
		this.vdao = vdao;
	}


	@Override 
	public int getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException{
		
		return vdao.getVoucherValueByNumber(voucher);
		
		 
	}

}
