package com.trl.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.Customer;
import com.trl.model.service.CustomerService;

@RestController
public class CustomerJsonResource {
	

	@Autowired
	private CustomerService customerService;

	
	@GetMapping(path="/json/customer/{phone}",produces = "application/json")
	public Customer getCustomerByPhone(@PathVariable("phone")long phone) {
				
		return customerService.getCustomerNameByPhone(phone);
			
	}

	@PostMapping(path = "/json/customer", produces = "application/json", consumes ="application/json" )
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	

}
