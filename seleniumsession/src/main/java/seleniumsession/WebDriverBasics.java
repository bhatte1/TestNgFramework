package seleniumsession;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		
		driver.getTitle();
		driver.getCurrentUrl();
		driver.quit();
	
	}

}
