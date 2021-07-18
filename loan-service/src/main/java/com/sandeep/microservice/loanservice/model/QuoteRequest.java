package com.sandeep.microservice.loanservice.model;

import java.math.BigDecimal;

public class QuoteRequest {

	private String productId;
	private int periodInMonths;
	private BigDecimal loanAmount;

	
	public QuoteRequest() {
		super();
	}

	public QuoteRequest(String cutomerName, String cutomerId, String productId, int periodInMonths,
			BigDecimal loanAmount) {
		super();
		
		this.productId = productId;
		this.periodInMonths = periodInMonths;
		this.loanAmount = loanAmount;
	}

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getPeriodInMonths() {
		return periodInMonths;
	}

	public void setPeriodInMonths(int periodInMonths) {
		this.periodInMonths = periodInMonths;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

}
