package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.pojo.Product;

public class ResultsPageTest extends BaseTest {
	
	

	@BeforeClass
	public void resultsPageSetup() {
		//login in to the lab and then search
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
//	/**
//	 * Data Provider
//	 * @return Product Names
//	 */
//	@DataProvider
//	public Object[][] getProductSearchKeyData() {
//		return new Object[][] {{"Macbook"},{"iMac"},{"Samsung"}};
//	}
	
	
	@DataProvider(name = "productData")
	public Object[][] getProductTestData() {
		return new Object[][] {
			{new Product("Macbook", "MacBook Pro", 4)},
			{new Product("iMac", "iMac", 3)}
			
		};
		
	}
	
	
	@Test(dataProvider="productData")  //Data Driven Approach
	public void aserchProductResultCountTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getSearchKey());
		
		Assert.assertTrue(resultsPage.getProductResultsCount()>0);
		}
	
//	
//	@Test(dataProvider="getProductSearchKeyData")  //Data Driven Approach
//	public void serchProductResultCountTest(String searchKey) {
//		resultsPage = accountsPage.doSearch(searchKey);
//		
//		Assert.assertTrue(resultsPage.getProductResultsCount()>0);
//		}
//	
	
	
//	@Test(priority =1)
//	public void serchProductResultCountTest() {
//		resultsPage = accountsPage.doSearch(prop.getProperty("search"));
//		Assert.assertTrue(resultsPage.getProductResultsCount()>0);
//		}
	
//	@Test(priority =2)
//	public void isMacBookAirDisplyed() {
//		
//		Assert.assertTrue(resultsPage.isMacBookAirVisible());
//		
//	}
	
	
	@Test(dataProvider="productData")
	public void bselectProductTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(product.getProdcutName());
		String actProductHeaderName = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actProductHeaderName, product.getProdcutName());
	}
	
//	@Test(dataProvider="productData")
//	public void productImageTest(Product product) {
//		resultsPage = accountsPage.doSearch(product.getSearchKey());
//		productInfoPage = resultsPage.selectProduct("MacBook Pro");
//		int actProductImageCount = productInfoPage.getProductImagesCount();
//		System.out.println("Total Images count are :"+actProductImageCount);
//		Assert.assertEquals(actProductImageCount, 4);
//	}
	
	@Test(dataProvider="productData")
	public void cproductImageTest(Product product) {
		resultsPage = accountsPage.doSearch(product.getSearchKey());
		productInfoPage = resultsPage.selectProduct(product.getProdcutName());
		int actProductImageCount = productInfoPage.getProductImagesCount();
		System.out.println("Total Images count are :"+actProductImageCount);
		Assert.assertEquals(actProductImageCount, product.getProductImages());
	}

}
