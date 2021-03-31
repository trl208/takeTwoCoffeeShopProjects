package com.trl.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.OrderDetail;
import com.trl.model.dao.OrderDetailsDao;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	@Autowired
	private OrderDetailsDao orderDetailDao ;
	
	/*
	 * public void setOrderDetailDao(OrderDetailsDao orderDetailDao) {
	 * this.orderDetailDao = orderDetailDao; }
	 */
	
	@Override
	public OrderDetail save(OrderDetail order) throws ClassNotFoundException, SQLException {
	
		OrderDetail od = orderDetailDao.save(order);
		return od;
	}

	/*
	 * @Override public void saveOrUpdate(OrderDetail order) throws
	 * ClassNotFoundException, SQLException { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void delete(OrderDetail order) throws
	 * ClassNotFoundException, SQLException { // TODO Auto-generated method stub
	 */		
//	}

	@Override
	public OrderDetail convertUpperCase(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
