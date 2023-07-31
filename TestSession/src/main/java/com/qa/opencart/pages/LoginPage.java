package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver; // default value == Null
	private ElementUtil eleUtil;

	// 1. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	// 2. private By locators:   
	//example of encasulation
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By footerLinks = By.xpath("//footer//a");

	// 3. page actions/methods:
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIsAndCapture("Account Login", 5);
	}

	public boolean isForgotPwdLinkExists() {
		return eleUtil.checkElementIsDisplayed(forgotPwdLink);
	}

	public List<String> getFooterLinksList() {

		List<WebElement> footerLinksList = eleUtil.waitForElementsVisible(footerLinks, 10);
		List<String> footerTextList = new ArrayList<String>();
		for (WebElement e : footerLinksList) {
			String text = e.getText();
			footerTextList.add(text);
		}

		return footerTextList;
	}
	
	public AccountsPage doLogin(String userName, String pwd) {
		eleUtil.waitForElementVisible(emailid, 10).sendKeys(userName);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		//driver.findElement(emailid).sendKeys(userName);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginBtn).click();
		//return next landing page -> page chaning model
		return new AccountsPage(driver);
	}

}
