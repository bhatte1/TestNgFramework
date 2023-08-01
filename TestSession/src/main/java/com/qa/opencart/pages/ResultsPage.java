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
	
	
	private By macbookAir = By.linkText("MacBook Air");
	
	
	public boolean isMacBookAirVisible() {	
		
		return eleUtil.checkElementIsDisplayed(macbookAir);		
	}
	

}