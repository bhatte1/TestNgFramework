package com.qa.opencart.test;

import org.testng.annotations.BeforeClass;

import com.qa.opencart.base.BaseTest;

public class ResultsPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		accountsPage = loginPage.doLogin("vinayakbhatte7@gmail.com", "vinayakbhatte");
		
	}

	
	

}
