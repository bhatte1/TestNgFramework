package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.frameworkexception.FrameException;

public class DriverFactory {

	WebDriver driver;
	OptionsManager om;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	// return the thread local copy of the driver
	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}


	public WebDriver initDriver(Properties prop) // call by reference
	{
		String bowserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is : " + bowserName);
		
		OptionsManager om = new OptionsManager(prop);

		switch (bowserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(om.getChromeOptions());
			break; 
		case "edge":
			driver = new EdgeDriver(om.getEdgeOptions());
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Please pass the right browser...." + bowserName);
			throw new FrameException("NOBROWSERFOUNDEXCEPTION");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public Properties initProperties() {

		Properties prop = new Properties();
		FileInputStream ip = null;

		String envName = System.getProperty("env");
		System.out.println("Runing test case on: " + envName);
		try {
			if (envName == null) {
				System.out.println("No env is given hence running on config env..env.");

				ip = new FileInputStream("./src/main/resources/config/config.properties");

			} else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("./src/main/resources/config/qa.config.properties");
					break;

				case "uat":
					ip = new FileInputStream("./src/main/resources/config/uat.config.properties");
					break;

				default:
					System.out.println("Please pass the right env: " + envName);

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//		try {
//			ip = new FileInputStream("./src/main/resources/config/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
	
	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}


}
