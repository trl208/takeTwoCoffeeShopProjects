package com.trl.resource;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trl.model.bean.Bill;
import com.trl.model.service.BillService;

@RestController
public class BillJsonResource {
    @Autowired 
	private BillService billService;
    
    @PostMapping(path = "/json/bill", produces = "application/json", consumes ="application/json" )
	public Bill saveBill(@RequestBody Bill bill) {
    	Bill bill1 = new Bill();
		try {
			bill1 =  billService.save(bill);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill1;
	}
	
	
}
