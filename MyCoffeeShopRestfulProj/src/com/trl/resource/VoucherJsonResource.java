package com.trl.resource;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.Voucher;
import com.trl.model.service.VoucherService;

@RestController
public class VoucherJsonResource {
    @Autowired
	private VoucherService voucherService;
	
    @GetMapping(path="/json/vouchers/{voucherId}",produces = "application/json")
	public Voucher getVoucherValueByNumber(@PathVariable("voucherId") int vnumber) {
				Voucher voucher = new Voucher();
				voucher.setVoucherId(vnumber);
				Voucher v1 =null;
		try {
			v1= voucherService.getVoucherValueByNumber(voucher);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return v1;
	}
    
    
}
