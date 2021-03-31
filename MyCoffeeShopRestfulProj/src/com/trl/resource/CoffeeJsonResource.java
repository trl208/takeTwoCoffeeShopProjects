package com.trl.resource;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.AddOns;
import com.trl.model.bean.Coffees;
import com.trl.model.service.AddOnService;
import com.trl.model.service.CoffeeService;

@RestController
public class CoffeeJsonResource {
	


	@Autowired
	private CoffeeService coffeeService;
	

	@GetMapping(path="/json/coffees",produces = "application/json")
	public Coffees getAllCoffees() {
		Coffees coffees = new Coffees();
		try {
			coffees =  coffeeService.getAllCoffeeRecords();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coffees;
	}
	

	


}
