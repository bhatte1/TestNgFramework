package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver; // default value == Null

	// 1. Constructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
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
		String title = driver.getTitle();
		System.out.println("login page title :" + title);
		return title;
	}

	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public List<String> getFooterLinksList() {

		List<WebElement> footerLinksList = driver.findElements(footerLinks);
		List<String> footerTextList = new ArrayList<String>();
		for (WebElement e : footerLinksList) {
			String text = e.getText();
			footerTextList.add(text);
		}

		return footerTextList;
	}
	
	public AccountsPage doLogin(String userName, String pwd) {
		driver.findElement(emailid).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		//return next landing page -> page chaning model
		return new AccountsPage(driver);
	}

}
