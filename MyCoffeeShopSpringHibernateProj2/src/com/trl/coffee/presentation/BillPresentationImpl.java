package com.trl.coffee.presentation;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trl.coffee.bean.Bill;
import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.bean.Voucher;
import com.trl.coffee.service.BillService;
import com.trl.coffee.service.BillServiceImpl;
import com.trl.coffee.service.CoffeeService;
import com.trl.coffee.service.CoffeeServiceImpl;

@Component("billPresent")
public class BillPresentationImpl implements BillPresentation {
	@Autowired
	BillService billService ;
	
	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	CoffeeService beverageService = new CoffeeServiceImpl();
	
	@Override
	public int generateBillWithVoucher(OrderDetail od, Voucher voucher, int total) {
		System.out.println(" Final Bill Invoice ");
		System.out.println("Total value: " +total);
        System.out.println("Discount : " + voucher.getVoucherValue());
        int netValue = total - voucher.getVoucherValue();
        System.out.println("Net value : "  + netValue);
        int gst = netValue * 18/100 ;
        int serviceTax = netValue * 8/100 ;
		System.out.println( "GST  : 18%  " +  gst);
		System.out.println( "GST  :  8%  " +  serviceTax);
		int totalBill = netValue + gst + serviceTax ;
		System.out.println(" Total Bill : " + totalBill);	
		try {
			billService.save(new Bill(1,od.getOrderId(),voucher.getVoucherId(),totalBill));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalBill;
	}

	@Override
	public int generateBillWithoutVoucher(OrderDetail od, int total) {
		System.out.println(" Final Bill Invoice ");
		System.out.println("Total value: " +total);
       // System.out.println("Discount : " + voucher.getVoucherValue());
        int netValue = total;
        System.out.println("Net value : "  + netValue);
        int gst = netValue * 18/100 ;
        int serviceTax = netValue * 8/100 ;
		System.out.println( "GST  : 18%  " +  gst);
		System.out.println( "Service Tax  :  8%  " +  serviceTax);
		int totalBill = netValue + gst +serviceTax ;
		System.out.println(" Total Bill : " + totalBill);	
		try {
			billService.save(new Bill(1,od.getOrderId(),totalBill,0));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalBill;
	}

	

	

}
