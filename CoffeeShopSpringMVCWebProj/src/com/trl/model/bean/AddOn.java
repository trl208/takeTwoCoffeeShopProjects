package com.trl.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddOn {
	@Id
	private int addOnId;
	private String addOnName;
	private int addOnPrice;
	
	
	
	public AddOn() {
		super();
	}
	public AddOn(int addOnId, String addOnName, int addOnPrice) {
		super();
		this.addOnId = addOnId;
		this.addOnName = addOnName;
		this.addOnPrice = addOnPrice;
	}
	public int getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(int addOnId) {
		this.addOnId = addOnId;
	}
	public String getAddOnName() {
		return addOnName;
	}
	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}
	public int getAddOnPrice() {
		return addOnPrice;
	}
	public void setAddOnPrice(int addOnPrice) {
		this.addOnPrice = addOnPrice;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
