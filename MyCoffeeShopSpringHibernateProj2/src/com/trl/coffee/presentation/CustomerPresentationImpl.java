package com.trl.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.bean.Customer;
import com.trl.coffee.bean.Voucher;
import com.trl.coffee.service.CustomerService;
import com.trl.coffee.service.VoucherServiceImpl;

@Component("customerPresentation")
public class CustomerPresentationImpl implements CustomerPresentation {
      Voucher voucher = null;
      @Autowired
	private VoucherServiceImpl voucherService ;
	
	//private CoffeeService coffeeService = new CoffeeServiceImpl();
      @Autowired
  	private CustomerService customerService ;
	public void setVoucherService(VoucherServiceImpl voucherService) {
		this.voucherService = voucherService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Voucher showVoucherMenu() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println(" Do you have any discount voucher ? ");
		 String response = sc.next();
		 if(response.equalsIgnoreCase("Yes")) {
			 System.out.println(" Please enter the voucher no. :");
			 int voucherNo = sc.nextInt();
			 voucher = new Voucher(voucherNo);
			 try {
				 
				  voucher.setVoucherValue( voucherService.getVoucherValueByNumber(voucher));
				//return voucher;
				  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 }else{
			voucher = null;
		 }
		//System.out.println(" Returning to coffee client ........ with voucher value " + voucher.getVoucherValue());
		// return voucher;	 
		return voucher;
		
	}

	@Override
	public void performVoucherMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer showMenu() {
		
		Customer customer = null;
			
			Scanner sc = new Scanner(System.in);
			String custName = null;
			ArrayList<Coffee> coffeeTypes = new ArrayList();
			System.out.println(" Please Enter your 10 digit phone number: ");
			long phone = sc.nextLong();
			try {
				 custName = customerService.getCustomerNameByPhone(phone);
				 if(custName!=null){
						System.out.println(" Your name is : " + custName);
					}else {
						System.out.println(" You are a first time customer ! Please enter your name ");
						custName = sc.next();
										
					}
				 customer = new Customer(phone,custName); 
				// System.out.println(" cust name n phone in cust presentation : " + custName + " " + phone);
				 customerService.save(customer);
				 				 
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return customer;
			
		}

	@Override
	public void showCoffeeMenu() {
		// TODO Auto-generated method stub
		
	}
		
		


}
