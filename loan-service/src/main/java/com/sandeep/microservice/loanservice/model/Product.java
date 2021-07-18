package com.sandeep.microservice.loanservice.model;

public class Product {

	private String productId;
	private String productName;

	public Product() {
		super();
	}

	public Product(String productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
