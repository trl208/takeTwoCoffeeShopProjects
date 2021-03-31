package com.trl.coffee.bean;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int detailId;
	//@ManyToOne
	//@JoinColumn(name = "orderId")
	private BigInteger orderId;
	private int beverageId;
	private int addonId;
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(int detailId, BigInteger orderId, int beverageId, int addonId) {
		super();
		this.detailId = detailId;
		this.orderId = orderId;
		this.beverageId = beverageId;
		this.addonId = addonId;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public BigInteger getOrderId() {
		return orderId;
	}
	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}
	public int getBeverageId() {
		return beverageId;
	}
	public void setBeverageId(int beverageId) {
		this.beverageId = beverageId;
	}
	public int getAddonId() {
		return addonId;
	}
	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}
	
	

	

}
