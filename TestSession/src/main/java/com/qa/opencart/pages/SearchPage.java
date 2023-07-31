package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	
	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver= driver;
	}
	
	
	private By macbookAir = By.linkText("MacBook Air");
	
	
	public boolean isMacBookAirVisible() {	
		
		return driver.findElement(macbookAir).isDisplayed();		
	}
	

}
