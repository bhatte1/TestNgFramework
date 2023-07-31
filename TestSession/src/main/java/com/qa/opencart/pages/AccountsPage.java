package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver; // default value == Null

	// 1. Constructor of the page class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logout = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By AccountPageHeaders = By.xpath("//div[@id = 'content']//h2");
	private By searh = By.name("search");
	private By searhIcon = By.cssSelector("div#search button");
	
	
	public String getAccPageTitle() {
		String title = driver.getTitle();
		System.out.println("Acc page title is: "+ title);
		return title;
	}
	
	public boolean isLogoutLinkExist() {
		return driver.findElement(logout).isDisplayed();
	}
	
	public boolean isAccountLinkExist() {
		return driver.findElement(myAccount).isDisplayed();
	}
	
	public List<String> getAccountPageHeadersList() {
		List<WebElement> accPageheaders =	driver.findElements(AccountPageHeaders);
		List<String> accPageHeaderList =  new ArrayList<String>();
		
		for(WebElement e:accPageheaders ) {
			accPageHeaderList.add(e.getText());
		}
		return accPageHeaderList;
	}
	
	public SearchPage doSearch(String searchTerm) {
		driver.findElement(searh).sendKeys(searchTerm);  //MAcbook
		driver.findElement(searhIcon).click();	
		return new SearchPage(driver);    //Test Driven approach
	}

}
