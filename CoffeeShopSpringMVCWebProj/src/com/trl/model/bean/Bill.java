package com.trl.model.bean;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {
    @Id
	private int billId;
	private BigInteger orderId;
	private int billValue;
	private int voucherId;
	
	
	
	public Bill(int billId, BigInteger orderId, int billValue, int voucherId) {
		super();
		this.billId = billId;
		this.orderId = orderId;
		this.billValue = billValue;
		this.voucherId = voucherId;
	}
	public Bill(int i, BigInteger orderId2, int billValue) {
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
	public BigInteger getOrderId() {
		return orderId;
	}
	public void setOrderId(BigInteger orderId) {
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
