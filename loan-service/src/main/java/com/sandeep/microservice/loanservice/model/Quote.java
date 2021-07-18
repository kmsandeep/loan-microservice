package com.sandeep.microservice.loanservice.model;

import java.math.BigDecimal;

public class Quote {

	private String productId;
	private String productName;
	private BigDecimal loanAmount;
	private int periodInMonths;
	private BigDecimal interestRate;
	private BigDecimal emi;

	public Quote() {
		super();
	}

	public Quote(String productId, String productName, BigDecimal loanAmount, int periodInMonths,
			BigDecimal interestRate, BigDecimal emi) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.loanAmount = loanAmount;
		this.periodInMonths = periodInMonths;
		this.interestRate = interestRate;
		this.emi = emi;
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

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getPeriodInMonths() {
		return periodInMonths;
	}

	public void setPeriodInMonths(int periodInMonths) {
		this.periodInMonths = periodInMonths;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public BigDecimal getEmi() {
		return emi;
	}

	public void setEmi(BigDecimal emi) {
		this.emi = emi;
	}

}
