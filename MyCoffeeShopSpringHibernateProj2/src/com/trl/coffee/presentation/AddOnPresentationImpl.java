package com.trl.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trl.coffee.bean.AddOn;
import com.trl.coffee.service.AddOnService;

@Component("addOnPresentation")
public class AddOnPresentationImpl implements AddOnPresentation {
     @Autowired
     private AddOnService addOnService ;
	
     
public void setAddOnService(AddOnService addOnService) {
		this.addOnService = addOnService;
	}

 public static  ArrayList<AddOn> addOnList ;
	    public static Set<String> addOnTypes = new HashSet();
	     
	@Override
	public AddOn showAddOnMenu() {
		Scanner sc = new Scanner(System.in);
		AddOn selectedAddOn = new AddOn();
		try {
			//if(addOnList != null &&  !addOnList.isEmpty()) {
			
			addOnList =addOnService.getAllAddOns();
			System.out.println("  addOnList size ...." + addOnList.size());
			for(AddOn addOn :addOnList) {
				addOnTypes.add(addOn.getAddOnName());
							 	
			}
		//	}
			System.out.println(" Please select from the addons shown below : ");
			System.out.println(addOnTypes);
			String addOnSelected = sc.next();
			
			selectedAddOn.setAddOnName(addOnSelected);
			
			//coffeeList.stream().filter(element->element.getcType().equalsIgnoreCase(coffeeSelected))
			selectedAddOn.setAddOnId(addOnList.stream().filter(element->element.getAddOnName().equalsIgnoreCase(addOnSelected)).findAny().get().getAddOnId());
			selectedAddOn.setAddOnPrice(addOnList.stream().filter(element->element.getAddOnName().equalsIgnoreCase(addOnSelected)).findAny().get().getAddOnPrice());
			
			 System.out.println(" -------------- addon  ........ " +selectedAddOn.getAddOnId() + "------price " + selectedAddOn.getAddOnPrice());
							
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedAddOn;
	}

}
