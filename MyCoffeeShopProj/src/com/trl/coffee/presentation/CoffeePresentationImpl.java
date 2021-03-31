package com.trl.coffee.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.trl.coffee.bean.Coffee;
import com.trl.coffee.service.CoffeeService;
import com.trl.coffee.service.CoffeeServiceImpl;

public class CoffeePresentationImpl implements CoffeePresentation {
   CoffeeService coffeeService = new CoffeeServiceImpl();
   ArrayList<Coffee> coffeeList = new ArrayList();

     Set  <String> coffeeTypes = new HashSet();
     Set  <String> coffeeSizes = new HashSet();
	@Override
	public Coffee showCoffeeMenu() {
		Scanner sc = new Scanner(System.in);
		Coffee selectedCoffee = new Coffee();
		try {
			coffeeList =coffeeService.getAllCoffeeRecords();
			//System.out.println("  coffeeList size ...." + coffeeList.size());
			for(Coffee coffee :coffeeList) {
				coffeeTypes.add(coffee.getcType());
				coffeeSizes.add(coffee.getcSize());
			 	
			}
			//System.out.println("  coffeeTypes size ...." + coffeeTypes.size());
			//System.out.println("  coffeeSizes size ...." + coffeeSizes.size());
			System.out.println(" Please select the flavour of coffee shown below : ");
			System.out.println( coffeeTypes);
			String coffeeSelected = sc.next();
			System.out.println(" Select size from below : ");
			System.out.println(coffeeSizes );
			String coffeeSize = sc.next();
			
			selectedCoffee.setcType(coffeeSelected);
			selectedCoffee.setcSize(coffeeSize);
			//coffeeList.stream().filter(element->element.getcType().equalsIgnoreCase(coffeeSelected))
			for(Coffee coffee :coffeeList) {
				if(coffee.getcType().equalsIgnoreCase(coffeeSelected) && coffee.getcSize().equalsIgnoreCase(coffeeSize)) {
					selectedCoffee.setcId(coffee.getcId());
					selectedCoffee.setcPrice(coffee.getcPrice());
					
				}
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedCoffee;
	}

}
