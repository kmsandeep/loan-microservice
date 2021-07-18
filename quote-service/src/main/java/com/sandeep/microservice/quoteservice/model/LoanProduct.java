package com.sandeep.microservice.quoteservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanProduct {
	@Id
	private Long id;
	private String productId;
	private String productName;
	
	public LoanProduct() {
		super();
	}

	public LoanProduct(String productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
