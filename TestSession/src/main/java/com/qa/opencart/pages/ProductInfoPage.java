package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetadata = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By quatity = By.xpath("//input[@id='input-quantity']");
	private By addToCartBtn = By.id("button-cart");
	private By alertTextLocator = By.xpath("//div[contains(@class,'alert-success')]");

	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}

	public String getProductHeaderName() {
		return eleUtil.doGetElementText(productHeader);

	}

	public int getProductImagesCount() {
		return eleUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();

	}

	public Map<String, String> getProductInfo() {
		productInfoMap = new HashMap<String, String>();
		getProductMetaData();
		getProductPriceData();
		productInfoMap.put("product Name", getProductHeaderName());
		return productInfoMap;
	}

	public void getProductMetaData() {
		List<WebElement> metaList = eleUtil.getElements(productMetadata);
		for (WebElement e : metaList) {
			String metaText = e.getText();
			String metaInfo[] = metaText.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);
		}
	}

	public void getProductPriceData() {
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String priceValue = priceList.get(0).getText();
		String exTaxPrice = priceList.get(1).getText();
		String exTaxPriceValue = exTaxPrice.split(":")[1].trim();

		productInfoMap.put("productPrice", priceValue);
		productInfoMap.put("taxPrice", exTaxPriceValue);
	}
	
	public void enterQuantityNeeded(String quantity) {
		eleUtil.getElement(quatity).sendKeys(quantity);
	}
	
	public void selectAddToCartBtn() {
		eleUtil.doClick(addToCartBtn);
	}
	
	public String getAlertMessage() {
		eleUtil.waitForElementsVisible(alertTextLocator, AppConstants.MEDIUM_DEFAULT_WAIT);
		return eleUtil.doGetElementText(alertTextLocator);
	}

}
