package com.qa.opencart.pojo;

public class Product {
	
	private String searchKey;
	private String prodcutName;
	private int productImages;
	
	public Product(String searchKey, String prodcutName, int productImages) {
		this.searchKey = searchKey;
		this.prodcutName = prodcutName;
		this.productImages = productImages;
	}
	
	public String getSearchKey() {
		return searchKey;
	}


//	public void setSearchKey(String searchKey) {
//		this.searchKey = searchKey;
//	}


	public String getProdcutName() {
		return prodcutName;
	}


//	public void setProdcutName(String prodcutName) {
//		this.prodcutName = prodcutName;
//	}


	public int getProductImages() {
		return productImages;
	}


//	public void setProductImages(int productImages) {
//		this.productImages = productImages;
//	}



	@Override
	public String toString() {
		return "Product [searchKey=" + searchKey + ", prodcutName=" + prodcutName + ", productImages=" + productImages
				+ "]";
	}


}
