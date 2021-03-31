package com.trl.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.Voucher;
import com.trl.model.dao.VoucherDao;
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
	VoucherDao vdao;
	
	public void setVdao(VoucherDao vdao) {
		this.vdao = vdao;
	}


	@Override 
	public Voucher getVoucherValueByNumber(Voucher voucher) throws ClassNotFoundException, SQLException{
		
		return vdao.getVoucherValueByNumber(voucher);
		
		 
	}

}
