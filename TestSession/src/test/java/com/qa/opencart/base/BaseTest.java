package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.pages.SearchPage;

public class BaseTest {

	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accountsPage;
	protected SearchPage searchPage;
	
	protected DriverFactory df;
	protected Properties prop;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProperties(); //this came from line 57 driverfactory
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
