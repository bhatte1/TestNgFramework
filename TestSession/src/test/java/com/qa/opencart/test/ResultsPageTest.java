package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.ResultsPage;

public class ResultsPageTest extends BaseTest {
	
	protected ResultsPage resultsPage;

	@BeforeClass
	public void searchPageSetup() {
		//login in to the lab and then search
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		resultsPage = accountsPage.doSearch(prop.getProperty("search"));
	}
	
	@Test
	public void isMacBookAirDisplyed() {
		
		Assert.assertTrue(resultsPage.isMacBookAirVisible());
		
	}
	

}
