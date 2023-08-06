package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	public ResultsPage(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	
	private By macbookPro = By.linkText("MacBook Pro");
	private By resultsProduct = By.cssSelector("div.product-layout.product-grid");
	private By searh = By.name("search");
	
	public String getResultsPageTitle(String searchKey) {
		return eleUtil.waitForTitleIsAndCapture(searchKey, 5);
		
	}
	
	public boolean isMacBookAirVisible() {	
		
		return eleUtil.checkElementIsDisplayed(macbookPro);		
	}
	
	public int getProductResultsCount() {
		int resultCount = eleUtil.waitForElementsVisible(resultsProduct, 10).size();
		System.out.println("Result Count "+ resultCount);
		return resultCount;
		
	}
	
	public ProductInfoPage selectProduct(String productName) {
		By productNameLocator = By.linkText(productName);
		eleUtil.doClick(productNameLocator);
		eleUtil.doClear(searh);
		return new ProductInfoPage(driver);
	}
	

}