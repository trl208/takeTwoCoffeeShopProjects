package com.trl.coffee.bean;

public class OrderDetail {
	
	private int detailId;
	private int orderId;
	private int beverageId;
	private int addonId;
	
	
	
	public OrderDetail(int detailId, int orderId, int beverageId, int addonId) {
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
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
