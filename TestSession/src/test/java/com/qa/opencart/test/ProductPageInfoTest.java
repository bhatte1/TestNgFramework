package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductPageInfoTest extends BaseTest {

	@BeforeClass
	public void resultsPageSetup() {
		//login in to the lab and then search
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		resultsPage = accountsPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		
	}
	
	@Test
	public void productInfoTest() {
		
		Map<String,String> productInfoMap = productInfoPage.getProductInfo();	
		System.out.println(productInfoMap);
		//Assert.assertEquals(productInfoMap.get("Brand"),"Apple");
		softAssert.assertEquals(productInfoMap.get("Brand"), "Apple");  //non static hence softassert object is created
		softAssert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		softAssert.assertEquals(productInfoMap.get("product Name"), "MacBook Pro");
		softAssert.assertEquals(productInfoMap.get("productPrice"), "$2,000.00");
		softAssert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		softAssert.assertAll();
	}
	
	@Test
	public void successMessageTest() {
//		resultsPage = accountsPage.doSearch("Macbook");
//		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		productInfoPage.enterQuantityNeeded("3");
		productInfoPage.selectAddToCartBtn();
		System.out.println(productInfoPage.getAlertMessage());
	}
	
	
	
	
	
	
}
