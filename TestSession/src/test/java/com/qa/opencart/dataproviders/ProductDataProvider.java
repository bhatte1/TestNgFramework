package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;

public class ProductDataProvider {
	
	
	@DataProvider(name = "productData")
	public Object[][] getProductTestData() {
		return new Object[][] {
			{new Product("Macbook", "MacBook Pro", 4)},
			{new Product("iMac", "iMac", 3)}
			
		};
		
	}

}
