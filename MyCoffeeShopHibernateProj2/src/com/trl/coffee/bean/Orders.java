package com.trl.coffee.bean;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false,unique = true)
   	private BigInteger orderId;
	//@Column(name = "cust_phone")
	private long custPhone;
	//@Column(name = "order_date")
	private Date orderDate;
	
	public Orders() {
		
	}
	
	public BigInteger getOrderId() {
		return orderId;
	}
	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}
	public long getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(long custPhone) {
		this.custPhone = custPhone;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	

}
