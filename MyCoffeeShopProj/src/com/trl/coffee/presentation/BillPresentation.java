package com.trl.coffee.presentation;

import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.bean.Voucher;

public interface BillPresentation {
	
	int generateBillWithVoucher(OrderDetail od, Voucher voucher, int total);
	int generateBillWithoutVoucher(OrderDetail od, int total);

}
