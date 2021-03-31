package com.trl.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voucher {
	
	@Id
	private int voucherId;
	private int voucherValue;
	
	
	public Voucher(int voucherId) {
		super();
		this.voucherId = voucherId;
	}
	public Voucher(int voucherId, int voucherValue) {
		super();
		this.voucherId = voucherId;
		this.voucherValue = voucherValue;
	}
	public Voucher() {
		// TODO Auto-generated constructor stub
	}
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public int getVoucherValue() {
		return voucherValue;
	}
	public void setVoucherValue(int voucherValue) {
		this.voucherValue = voucherValue;
	}
	
	

}
