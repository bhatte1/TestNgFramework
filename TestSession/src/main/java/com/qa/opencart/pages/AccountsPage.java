package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver; // default value == Null
	private ElementUtil eleUtil;

	// 1. Constructor of the page class
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	private By logout = By.linkText("Logout");
	private By myAccount = By.linkText("My Account");
	private By AccountPageHeaders = By.xpath("//div[@id = 'content']//h2");
	private By searh = By.name("search");
	private By searhIcon = By.cssSelector("div#search button");
	
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleIsAndCapture("My Account", 5);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.checkElementIsDisplayed(logout);
	}
	
	public boolean isAccountLinkExist() {
		return eleUtil.checkElementIsDisplayed(myAccount);
	}
	
	public List<String> getAccountPageHeadersList() {
		List<WebElement> accPageheaders =	eleUtil.waitForElementsVisible(AccountPageHeaders, 10) ;
		List<String> accPageHeaderList =  new ArrayList<String>();
		
		for(WebElement e:accPageheaders ) {
			accPageHeaderList.add(e.getText());
		}
		return accPageHeaderList;
	}
	
	public ResultsPage doSearch(String searchTerm) {
		
		eleUtil.waitForElementVisible(searh, 10).sendKeys(searchTerm);
		eleUtil.doClick(searhIcon);
//		driver.findElement(searh).sendKeys(searchTerm);  //MAcbook
//		driver.findElement(searhIcon).click();	
		return new ResultsPage(driver);    //Test Driven approach
	}

}
