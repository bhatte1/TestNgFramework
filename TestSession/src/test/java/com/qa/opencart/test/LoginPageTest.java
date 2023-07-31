package com.qa.opencart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;



public class LoginPageTest extends BaseTest{
	
	
	@Test
	public void loginPageTitleTest() {
	String actTitle = loginPage.getLoginPageTitle();
	Assert.assertEquals(actTitle,"Account Login");
	
	}
	
	@Test
	public void forgotPasswordLinkExistText() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExists());	
	
	}
	


}
