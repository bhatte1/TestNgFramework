package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.AppConstants;



public class LoginPageTest extends BaseTest{
	
	
	@Test
	public void loginPageTitleTest() {
	String actTitle = loginPage.getLoginPageTitle();
	Assert.assertEquals(actTitle,AppConstants.LOGIN_PAGE_TITLE_VALUE);
	
	}
	
	@Test
	public void forgotPasswordLinkExistText() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExists());	
	
	}
	
	@Test
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accountsPage.isLogoutLinkExist());
		Assert.assertTrue(accountsPage.getAccPageTitle().equals(AppConstants.ACCOUNTS_PAGE_TITLE_VALUE));
	}
	


}
