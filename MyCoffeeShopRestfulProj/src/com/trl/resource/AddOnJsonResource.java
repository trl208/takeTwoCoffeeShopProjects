package com.trl.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.AddOns;
import com.trl.model.service.AddOnService;

@RestController
public class AddOnJsonResource {

	@Autowired
	private AddOnService addOnService;
	

	@GetMapping(path="/json/addOns",produces = "application/json")
	public AddOns getAllAddOns() {
		return addOnService.getAllAddOns();
	}
	

	
}
