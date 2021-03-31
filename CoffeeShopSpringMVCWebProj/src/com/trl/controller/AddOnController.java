package com.trl.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.trl.model.bean.Coffee;
import com.trl.model.bean.Coffees;
import com.trl.model.bean.Customer;
import com.trl.model.bean.Orders;
import com.trl.model.sevice.AddOnService;
import com.trl.model.sevice.CoffeeService;

@Controller
@SessionAttributes({"customer","coffeeOrder","coffees","selectedAddOns"})

public class AddOnController {
	@Autowired
	private AddOnService addOnService;
	@Autowired
	private CoffeeService coffeeService;
	
	
	@RequestMapping("/getAddOns")
	public ModelAndView getAddOnsController(@ModelAttribute("customer") Customer customer,@ModelAttribute("coffeeOrder") Orders orders,@ModelAttribute("coffees") Coffees coffees,HttpServletRequest request,Model model) {
		Coffees selectedCoffees = new Coffees();
		AddOns selectedAddOns = new AddOns();
		String[] selectedCoffeeIds = request.getParameterValues("cid");
		List<Coffee> selectedcoffees=getSelectedCoffees(selectedCoffeeIds);
		selectedCoffees.setCoffeeList(selectedcoffees);
		System.out.println(" in getAddOnCOntroller ==========customer phone " + customer.getCustPhone() + " order id " + orders.getOrderId());
		List<AddOn> addOnsList = new ArrayList<AddOn>();
		ModelAndView mv = new ModelAndView();
		try {
			addOnsList = addOnService.getAllAddOns();
			 System.out.println("addon list size........." + addOnsList.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> addOnNames=addOnsList.stream().map(AddOn::getAddOnName).distinct().collect(Collectors.toList());
		model.addAttribute("customer", customer);
		model.addAttribute("coffeeOrder", orders);
		model.addAttribute("coffees", selectedCoffees);
		model.addAttribute("selectedAddOns", selectedAddOns);
		mv.addObject("customer", customer);
		mv.addObject("coffeeOrder", orders);
		mv.addObject("coffees",selectedCoffees);
		mv.addObject("addOnsList",addOnsList);
		mv.addObject("addOnNames", addOnNames);
	    mv.addObject("addOnSelections", new AddOns());
		mv.addObject("addOn" , new AddOn());
		mv.setViewName("getAddOns");
		return mv;
		
	}

	public List<Coffee> getSelectedCoffees(String[] cids){
		List<Coffee> selectedcoffees = new ArrayList<>();
		String[] selectedCoffeeIds = cids;
		try {
			List<Coffee> coffees = coffeeService.getAllCoffeeRecords();
			for(int i=0;i<selectedCoffeeIds.length;i++) {
				if(selectedCoffeeIds[i] != null) {
				int cofid = Integer.parseInt(selectedCoffeeIds[i]);
				
				System.out.println(" req param in add controller----------- " +i + cofid);
			   for(int x=0;x<coffees.size();x++) {
				if(cofid==coffees.get(x).getcId()) {
					
					selectedcoffees.add(coffees.get(x));
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
		System.out.println(" in addon controller get selected method ======selected coffees : " + selectedcoffees.size());
		return selectedcoffees;
		
	}
	
	@ModelAttribute("addOnNames")
	public List<String> getAllAddOnNames(){
		ArrayList<AddOn> addOnList = new ArrayList<AddOn>();
		try {
			addOnList = addOnService.getAllAddOns();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> addOnNames=addOnList.stream().map(AddOn::getAddOnName).distinct().collect(Collectors.toList());
		return addOnNames;
	}
	

	@RequestMapping("/saveAddon")
	public ModelAndView saveAddonController(@ModelAttribute("addOnSelections") AddOns addOnsSelected){
		ModelAndView mv=new ModelAndView();
		mv.addObject("addOnSelections",addOnsSelected);
		System.out.println("selected addons number : " + addOnsSelected.getAddOnSelection().size());
		String message=null;
		/*if(empService.insertEmployee(employee))
			message="Employee Record Inserted Succesfully!";
		else
			message="Employee Record Insertion Failed";
	*/	mv.addObject("message", message);
		mv.setViewName("getCoffees");
		return mv;
	}

	
}
