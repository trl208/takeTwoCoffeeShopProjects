package com.trl.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.trl.model.bean.AddOn;
import com.trl.model.bean.AddOns;
import com.trl.model.bean.Bill;
import com.trl.model.bean.Coffee;
import com.trl.model.bean.Coffees;
import com.trl.model.bean.Customer;
import com.trl.model.bean.Invoice;
import com.trl.model.bean.OrderDetail;
import com.trl.model.bean.Orders;
import com.trl.model.bean.Voucher;
import com.trl.model.sevice.AddOnService;
import com.trl.model.sevice.BillService;
import com.trl.model.sevice.OrderDetailsService;
import com.trl.model.sevice.VoucherService;

@Controller
@SessionAttributes({"customer","coffeeOrder","coffees","selectedAddOns"})
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	@Autowired
	private AddOnService addOnService;
	@Autowired
	private BillService billService;
    @Autowired
	private VoucherService vouhcerService;
	
	
	@RequestMapping("/generateOrder")
	public ModelAndView generateOrderController(@ModelAttribute("customer") Customer customer,@ModelAttribute("coffeeOrder") Orders order,@ModelAttribute("coffees") Coffees coffees,@ModelAttribute("selectedAddOns") AddOns selectedAddOns, Model model , HttpServletRequest request) {
		Voucher custVoucher=null;
		//AddOns selectedaddons = new AddOns();
		String[] selectedAddOnIds = request.getParameterValues("aid");
		String vouchNum = request.getParameter("voucher");
		if(vouchNum != null || vouchNum != "") {
		custVoucher = new Voucher(Integer.parseInt(vouchNum));
		int voucherVal=0;
		try {
			voucherVal = vouhcerService.getVoucherValueByNumber(custVoucher);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		custVoucher.setVoucherValue(voucherVal);
		}
		System.out.println("in generateOrderController=====" + "voucherno. " + vouchNum + " selectedAddOnIds  " + selectedAddOnIds.length) ;
		List<AddOn> selectAddOns=getSelectedAddOns(selectedAddOnIds);
		System.out.println("in generateOrderController=====" + "selectedAddOns. " + " selectedAddOnIds " + selectedAddOnIds.length  + "  "+ selectAddOns.size() + "  " + selectAddOns.toString());
		selectedAddOns.setAddOnSelection(selectAddOns);
		System.out.println(" in generateOrderController ==========customer phone " + customer.getCustPhone() + " order id " + order.getOrderId());
		System.out.println(" in generateOrderController ==========selected coffees " + coffees.getCoffeeList().size());
		List<AddOn> addOnsList = new ArrayList<AddOn>();
		//Saving order details   
		int totalCoffeePrice = 0;
		for(int i=0;i<coffees.getCoffeeList().size();i++ ) {
			  totalCoffeePrice = totalCoffeePrice + coffees.getCoffeeList().get(i).getcPrice();			
			  System.out.println("Coffee totalCoffeePrice: " +totalCoffeePrice );
			try {
				if( selectAddOns.get(i) !=null)
			    	orderDetailsService.save(new OrderDetail(123,order.getOrderId(),coffees.getCoffeeList().get(i).getcId(),selectAddOns.get(i).getAddOnId()));
				else
					orderDetailsService.save(new OrderDetail(123,order.getOrderId(),coffees.getCoffeeList().get(i).getcId(),0));	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		     
			  int addonTotal = 0;
			  for(int i=0;i< selectAddOns.size();i++)
		  {
				  addonTotal = addonTotal + selectAddOns.get(i).getAddOnPrice();
				  System.out.println("AddOn : addonTotal  " + addonTotal);
				  }
		  
		    //System.out.println("Total addon...price...." + addonTotal);
		  int total =  totalCoffeePrice + addonTotal;
		  
		  	Invoice invoice=  generateBill(order,custVoucher,total);
		  		
		
		
		model.addAttribute("vouchNum", vouchNum);
		model.addAttribute("customer", customer);
		model.addAttribute("coffeeOrder", order);
		model.addAttribute("coffees", coffees);
		model.addAttribute("selectedAddOns", selectedAddOns);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vouchNum", vouchNum);
		mv.addObject("customer", customer);
		mv.addObject("coffeeOrder", order);
		mv.addObject("coffees", coffees);
	    mv.addObject("selectedAddOns", selectedAddOns);
	    mv.addObject("invoice", invoice);
		//mv.addObject("addOn",new AddOn());
		mv.setViewName("orderdetailsPage");
		return mv;
		
		
	}


	private List<AddOn> getSelectedAddOns(String[] aids) {
		List<AddOn> selectedaddons = new ArrayList<>();
		String[] selectedAddOnIds = aids;
		try {
			List<AddOn> addons = addOnService.getAllAddOns();
			for(int i=0;i<selectedAddOnIds.length;i++) {
				if(selectedAddOnIds[i] != null) {
				int adonid = Integer.parseInt(selectedAddOnIds[i]);
				
				System.out.println(" req param in orderdetail  controller----------- " +i + adonid);
			   for(int x=0;x<addons.size();x++) {
				if(adonid==addons.get(x).getAddOnId()) {
					
					selectedaddons.add(addons.get(x));
				}}
			   }
			   }
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return selectedaddons;
		
	}
	
	public Invoice generateBill(Orders order, Voucher voucher, int total) {
		System.out.println(" Final Bill Invoice ");
		System.out.println("Total value: " +total);
		Invoice invoice = new Invoice();
		int netValue = 0;
		invoice.setTotalValue(total);
        if(voucher !=null) {
           invoice.setDiscount(voucher.getVoucherValue());
        	netValue = total - voucher.getVoucherValue();
         
		}else {
			invoice.setDiscount(0);
			netValue = total;
		}
	     System.out.println("Net value : "  + netValue);
	        int gst = netValue * 18/100 ;
	        int serviceTax = netValue * 8/100 ;
			System.out.println( "GST  : 18%  " +  gst);
			System.out.println( "GST  :  8%  " +  serviceTax);
			int totalBill = netValue + gst + serviceTax ;
			System.out.println(" Total Bill : " + totalBill);	

			invoice.setNetValue(netValue);
			invoice.setGst(gst);
			invoice.setServiceTax(serviceTax);
			invoice.setTotalBIllValue(totalBill);
		try {
			billService.save(new Bill(1,order.getOrderId(),voucher.getVoucherId(),totalBill));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoice;
	}
	
	

	

	

}
