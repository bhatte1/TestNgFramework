package seleniumsession;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com"); 
		
		driver.navigate().refresh();
		
		driver.navigate().to("https://www.google.com");
	}

}
