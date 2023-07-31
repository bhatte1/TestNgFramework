package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchPageTest extends BaseTest {
	
	
	@BeforeTest
	public void searchPageSetup() {
		//login in to the lab and then search
		accountsPage = loginPage.doLogin("vinayakbhatte7@gmail.com", "vinayakbhatte");
		searchPage = accountsPage.doSearch("Macbook");
	}
	
	@Test
	public void isMacBookAirDisplyed() {
		
		Assert.assertTrue(searchPage.isMacBookAirVisible());
		
	}
	

}
