package com.trl.coffee.presentation;

import com.trl.coffee.bean.Customer;
import com.trl.coffee.bean.Voucher;

public interface CustomerPresentation {
	
	public Customer showMenu();

	public Voucher showVoucherMenu();
	public void performVoucherMenu();

	public void showCoffeeMenu();
	
	
	
}
