package com.trl.coffee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private long custPhone;
	private String name;
	
	public Customer() {
		
	}
	public Customer(long phone, String name) {
		super();
		this.custPhone = phone;
		this.name = name;
	}
	public long getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(int custPhone) {
		this.custPhone = custPhone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
