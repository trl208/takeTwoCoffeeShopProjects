package com.trl.coffee.client;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import com.trl.coffee.bean.AddOn;
import com.trl.coffee.bean.Coffee;
import com.trl.coffee.bean.Customer;
import com.trl.coffee.bean.OrderDetail;
import com.trl.coffee.bean.Orders;
import com.trl.coffee.bean.Voucher;
import com.trl.coffee.presentation.AddOnPresentation;
import com.trl.coffee.presentation.AddOnPresentationImpl;
import com.trl.coffee.presentation.BillPresentation;
import com.trl.coffee.presentation.BillPresentationImpl;
import com.trl.coffee.presentation.CoffeePresentation;
import com.trl.coffee.presentation.CoffeePresentationImpl;
import com.trl.coffee.presentation.CustomerPresentation;
import com.trl.coffee.presentation.CustomerPresentationImpl;
import com.trl.coffee.presentation.OrderDetailsPresentation;
import com.trl.coffee.presentation.OrderDetailsPresentationImpl;
import com.trl.coffee.presentation.OrderPresent;
import com.trl.coffee.presentation.OrderPresentImpl;

public class CoffeeClient {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Coffee> selection = new ArrayList();
		ArrayList<AddOn> addOnList = new ArrayList();
		CustomerPresentation cp = new CustomerPresentationImpl();
		CoffeePresentation coffeePresentation = new CoffeePresentationImpl();
		AddOnPresentation addOnPresent = new AddOnPresentationImpl();
		OrderPresent orderPresent = new OrderPresentImpl();
		OrderDetailsPresentation orderDetails= new OrderDetailsPresentationImpl();
		Orders order = new Orders();
		Coffee coffeeSelected = null;
		AddOn addOn = null;
		
		Customer customer= cp.showMenu();
				
		String resAddOn = "Yes";
		String resCoffee = "Yes";
		//coffeeSelected = coffeePresentation.showCoffeeMenu();
		
		  do{ 
			  coffeeSelected = coffeePresentation.showCoffeeMenu();
		  selection.add(coffeeSelected);
		  do{
			  addOn = addOnPresent.showAddOnMenu();
		  addOnList.add(addOn);
		  System.out.println(" Do you want more addons ? : Yes or No ");
		  resAddOn =  sc.next();
		  }while(resAddOn.equalsIgnoreCase("Yes"));
		  System.out.println(" Do you want more coffee ? : Yes or No "); 
		  resCoffee = sc.next(); 
		  }while(resCoffee.equalsIgnoreCase("Yes"));
		  
		  //generateOrder
		  order.setCustPhone(customer.getCustPhone()); 
		  BigInteger orderId = orderPresent.generateOrder(order);
		  order.setOrderId(orderId);
		  
		  
		  Voucher voucher =cp.showVoucherMenu();
		  
		  BillPresentation billPresent = new BillPresentationImpl();
		  OrderDetailsPresentationImpl odpi = new OrderDetailsPresentationImpl();
		  OrderDetail od = new OrderDetail(123,order.getOrderId(),coffeeSelected.getcId(),addOn.getAddOnId());
		  odpi.saveOrderDetails(od);
		  int totalCoffeePrice = 0; 
		  for(int i=0;i<selection.size();i++)
		  { 
			  totalCoffeePrice = totalCoffeePrice + selection.get(i).getcPrice(); 
			  System.out.println("Coffee : " + selection.get(i).getcType() + " Price : " + selection.get(i).getcPrice());
		  }
		    
			  int addonTotal = 0;
			  for(int i=0;i< addOnList.size();i++)
		  {
				  addonTotal = addonTotal + addOnList.get(i).getAddOnPrice();
				  System.out.println("AddOn : " + addOnList.get(i).getAddOnName() + " Price : " + addOnList.get(i).getAddOnPrice());
				  }
		  
		    //System.out.println("Total addon...price...." + addonTotal);
		  int total =  totalCoffeePrice + addonTotal;
		  
		  if(voucher != null) { 
			  billPresent.generateBillWithVoucher(od,voucher,total);
		  }else { 
			  billPresent.generateBillWithoutVoucher(od,total); 
			  }
		 

	}

}
