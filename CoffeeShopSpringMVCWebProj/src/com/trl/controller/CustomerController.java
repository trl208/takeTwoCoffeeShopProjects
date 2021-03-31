package com.trl.controller;

import java.math.BigInteger;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.trl.model.bean.Customer;
import com.trl.model.bean.Orders;
import com.trl.model.sevice.CustomerService;
import com.trl.model.sevice.OrderService;


@Controller
@ControllerAdvice
@SessionAttributes({"customer","coffeeOrder"})
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/")
	public ModelAndView coffeeShopLaunchPageController(Model model) {
       Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return new ModelAndView("coffeeShopLaunchPage","command",new Customer());
		
	}
	
	  @RequestMapping("/getCustomer") 
	  public ModelAndView getCustomerController(@ModelAttribute("customer") Customer customer,Model model) {
		  ModelAndView mv=new ModelAndView(); 
		 // long phone=Long.parseLong(request.getParameter("phone"));
	     String message=null;
	   Customer customerTemp = null;
	   Orders orders = null;
	try {
		customerTemp= customerService.getCustomerNameByPhone(customer.getCustPhone());
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   if((customer.getName()==null) || (customer.getName()=="")) {
	  message = customer.getCustPhone() + " You are a first time customer ";
	  mv.addObject("message", message);
	  mv.addObject("customer", customerTemp);
	  mv.setViewName("showCustomer");
	   }
	   else {
		   try {
			    orders = new Orders();
			   orders.setCustPhone(customerTemp.getCustPhone());
			  BigInteger id = orderService.save(orders);
			  System.out.println(" In cust controller getcust if not a first time cust genarating order  orderid : " + id);
			  orders.setOrderId(id);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   model.addAttribute("customer", customerTemp);
		   model.addAttribute("coffeeOrder", orders);
		   //return new ModelAndView("forward:/getCoffees");
		mv.addObject("message", "You are an existing customer. Please select from the coffee menu ");  
		mv.addObject("customer", customerTemp);
		  mv.addObject("coffeeOrder", orders);
		mv.setViewName("forward:/getCoffees");
	  } 
	  	 
	   return mv; 
	  }
	
	  @RequestMapping("/saveCustomer")
		public ModelAndView saveCustomerController(@ModelAttribute("customer") Customer customer,Model model) {
		     ModelAndView mv=new ModelAndView();
		     System.out.println("in customer controller save customer b4 saving custname : " + customer.getName());
		     Customer customer1 = customer;
		     Orders orders = null;
		     
			try {
				customerService.save(customer1);
				 orders = new Orders();
				   orders.setCustPhone(customer.getCustPhone());
				  BigInteger id = orderService.save(orders);
				  orders.setOrderId(id);
				  
				  System.out.println("in save cust order id : " + id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message=null;
			  model.addAttribute("customer", customer);
			   model.addAttribute("coffeeOrder", orders);
			  mv.addObject("customer", customer);
			     mv.addObject("coffeeOrder", orders);
//			     mv.addObject("coffeeOrder", orders);
		     // mv.addObject("customer", customer);
		       mv.setViewName("forward:/getCoffees");
			//return new ModelAndView("forward:/getCoffees");
			 return mv;
			 //"redirect:/getCoffees.do";
		}
	 
	

}
