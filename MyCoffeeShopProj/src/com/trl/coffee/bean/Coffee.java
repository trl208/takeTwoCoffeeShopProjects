package com.trl.coffee.bean;

public class Coffee {
	
	private int cId;
	private int cPrice;
	private String cType;
	private String cSize;
	
	public Coffee() { }

	public Coffee(int cId, int cPrice, String cType, String cSize) {
		super();
		this.cId = cId;
		this.cPrice = cPrice;
		this.cType = cType;
		this.cSize = cSize;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcSize() {
		return cSize;
	}

	public void setcSize(String cSize) {
		this.cSize = cSize;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Coffee [beverage_id=" + cId + ", beverage_name=" + cType + ", Size=" + cSize + ", price=" + cPrice + "]";
		//return super.toString();
	}
}
