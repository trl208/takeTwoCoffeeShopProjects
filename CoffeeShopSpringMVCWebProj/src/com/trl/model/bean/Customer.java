package com.trl.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Proxy;

@Entity
//@Proxy(lazy=false)

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
	public void setCustPhone(long phone) {
		this.custPhone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
