package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchPageTest extends BaseTest {
	
	
	@BeforeTest
	public void searchPageSetup() {
		//login in to the lab and then search
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchPage = accountsPage.doSearch(prop.getProperty("search"));
	}
	
	@Test
	public void isMacBookAirDisplyed() {
		
		Assert.assertTrue(searchPage.isMacBookAirVisible());
		
	}
	

}
