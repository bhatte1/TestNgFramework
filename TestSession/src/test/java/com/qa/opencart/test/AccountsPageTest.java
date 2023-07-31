package com.qa.opencart.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetup() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@Test
	public void accPageTitleTest() {
		String accTitle = accountsPage.getAccPageTitle();
		Assert.assertEquals(accTitle,"My Account");
	}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageHeaderList() {
		List<String> actHeaderList = accountsPage.getAccountPageHeadersList();
		List<String> expAccHeaderList = Arrays.asList("My Account","My Orders", "My Affiliate Account", "Newsletter");
		Assert.assertEquals(actHeaderList , expAccHeaderList);
	}
	

}
