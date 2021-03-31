package com.trl.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trl.model.bean.AddOns;
import com.trl.model.dao.AddOnDao;
@Service
public class AddOnServiceImpl implements AddOnService {

	@Autowired
	private AddOnDao addOnDao;

	public void setAddOnDao(AddOnDao addOnDao) {
		this.addOnDao = addOnDao;
	}
	

	@Override
	public AddOns getAllAddOns() {
		AddOns addOns = new AddOns();
		addOns.setAddOns(addOnDao.getAllAddOns());
		return addOns;
		//return null;
	} 

}
