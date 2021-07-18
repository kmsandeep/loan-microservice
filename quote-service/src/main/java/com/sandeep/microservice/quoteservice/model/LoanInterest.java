package com.sandeep.microservice.quoteservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanInterest {
	@Id
	private Long id;
	private String productId;
	private BigDecimal interestRate;
	
	public LoanInterest() {
		super();
	}
	public LoanInterest(Long id, String productId, BigDecimal interestRate) {
		super();
		this.id = id;
		this.productId = productId;
		this.interestRate = interestRate;
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
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	

}
