package com.trl.model.bean;


public class Invoice {
	
	private int totalValue;
	private int netValue;
	private int gst;
	private int serviceTax;
	private int totalBIllValue;
	private int discount;
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	public int getNetValue() {
		return netValue;
	}
	public void setNetValue(int netValue) {
		this.netValue = netValue;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getGst() {
		return gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	public int getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(int serviceTax) {
		this.serviceTax = serviceTax;
	}
	public int getTotalBIllValue() {
		return totalBIllValue;
	}
	public void setTotalBIllValue(int totalBIllValue) {
		this.totalBIllValue = totalBIllValue;
	}
	
		
	

}
