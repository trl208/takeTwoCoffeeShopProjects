package com.trl.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.trl.model.bean.AddOns;
import com.trl.model.service.AddOnService;

public class AddOnResource {
	
	@Autowired
	private AddOnService addOnService;

	@GetMapping(path="/addOns",produces = "application/xml")
	public AddOns getAllAddOns() {
		return addOnService.getAllAddOns();
	}
	


}
