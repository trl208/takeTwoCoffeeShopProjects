package com.trl.coffee.bean;

public class Bill {

	private int billId;
	private int orderId;
	private int billValue;
	private int voucherId;
	
	
	
	public Bill(int billId, int orderId, int billValue, int voucherId) {
		super();
		this.billId = billId;
		this.orderId = orderId;
		this.billValue = billValue;
		this.voucherId = voucherId;
	}
	public Bill(int i, int orderId2, int billValue) {
		super();
	this.billId = i;
	this.orderId = orderId2;
	this.billValue = billValue;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBillValue() {
		return billValue;
	}
	public void setBillValue(int billValue) {
		this.billValue = billValue;
	}
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	
	
	
	
}
