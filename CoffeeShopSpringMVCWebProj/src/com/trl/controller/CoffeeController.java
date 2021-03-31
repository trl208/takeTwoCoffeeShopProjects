package com.trl.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.trl.model.bean.AddOn;
import com.trl.model.bean.Coffee;
import com.trl.model.bean.Coffees;
import com.trl.model.bean.Customer;
import com.trl.model.bean.Orders;
import com.trl.model.sevice.AddOnService;
import com.trl.model.sevice.CoffeeService;

@Controller
@ControllerAdvice
@SessionAttributes({"customer","coffeeOrder","coffees"})
public class CoffeeController {
	

	@Autowired
	private CoffeeService coffeeService;
	
	@Autowired
	private AddOnService addOnService;
	List<Coffee> selectedcoffees = new ArrayList<Coffee>();
	Coffees coffees  = new Coffees();
	@RequestMapping("/getCoffees")
	public ModelAndView getCoffeesController(@ModelAttribute("customer") Customer customer,@ModelAttribute("coffeeOrder") Orders orders,Model model) {
		List<Coffee> coffeeList = new ArrayList<Coffee>();
		List<String> selectedcTypes = new ArrayList<String>();
		List<String> selectedcSizes = new ArrayList<String>();
		//List<AddOn> addOnList = new ArrayList<AddOn>();
		ModelAndView mv = new ModelAndView();
		try {
			 coffeeList = coffeeService.getAllCoffeeRecords();
			 System.out.println("coffeeeeeeeeee list size........." + coffeeList);
			 System.out.println("customer in coffeeas..." + customer.getName());
			 System.out.println("order id  in coffeeas..." + orders.getOrderId());
			 coffees.setCoffeeList(coffeeList);
			// addOnList = addOnService.getAllAddOns();
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("customer", customer);
		model.addAttribute("coffeeOrder", orders);
		model.addAttribute("coffees", coffees);
		mv.addObject("customer", customer);
         mv.addObject("coffeeOrder", orders);
		mv.addObject("coffeeList",coffeeList);
		mv.addObject("coffee" , new Coffee());
		mv.addObject("selectedcTypes",selectedcTypes );
		mv.addObject("selectedcSizes", selectedcSizes);
		mv.addObject("coffees", coffees);
		/*
		 * mv.addObject("addOnList",addOnList); mv.addObject("addOn", new AddOn());
		 */	mv.setViewName("getCoffees");
		return mv;
		
	}
	
	@ModelAttribute("coffeeIds")
	public List<Integer> getAllCoffeeIds(){
		ArrayList<Coffee> coffeeList  = new ArrayList();
		try {
			coffeeList = coffeeService.getAllCoffeeRecords();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> coffeeIds=coffeeList.stream().map(Coffee::getcId).collect(Collectors.toList());
		return coffeeIds;
	}
	@ModelAttribute("coffeeTypes")
	public List<String> getAllCoffeeTypes(){
		ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();
		try {
			coffeeList = coffeeService.getAllCoffeeRecords();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> coffeeTypes=coffeeList.stream().map(Coffee::getcType).distinct().collect(Collectors.toList());
		return coffeeTypes;
	}
	
	@ModelAttribute("coffeeSizes")
	public List<String> getAllDesignations(){
		ArrayList<Coffee> coffeeList  = new ArrayList<Coffee>();
		try {
			coffeeList = coffeeService.getAllCoffeeRecords();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> coffeeSizes=coffeeList.stream().map(Coffee::getcSize).distinct().collect(Collectors.toList());
		return coffeeSizes;
	}
	
	/*
	 * @RequestMapping("/getAddOns") public ModelAndView getAddOnsController() {
	 * List<AddOn> addOnsList = new ArrayList<AddOn>(); ModelAndView mv = new
	 * ModelAndView(); try { addOnsList = addOnService.getAllAddOns();
	 * System.out.println("addon list size........." + addOnsList.size()); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } mv.addObject("addOnsList",addOnsList);
	 * mv.addObject("addOn" , new AddOn()); mv.setViewName("getAddOns"); return mv;
	 * 
	 * }
	 * 
	 * @ModelAttribute("addOnNames") public List<String> getAllAddOnNames(){
	 * ArrayList<AddOn> addOnList = new ArrayList<AddOn>(); try { addOnList =
	 * addOnService.getAllAddOns(); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } List<String>
	 * addOnNames=addOnList.stream().map(AddOn::getAddOnName).distinct().collect(
	 * Collectors.toList()); return addOnNames; }
	 * 
	 */

}
