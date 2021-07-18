package com.sandeep.microservice.loanservice.utility;

import java.math.BigDecimal;

public class LoanServiceUtils {
	
	public static BigDecimal emiCalculator (BigDecimal loanAmount, BigDecimal interestRate, int periodInMonths)
	{
		double principal = loanAmount.doubleValue();
		double rate = interestRate.doubleValue()/(12*100);
		double time = Double.valueOf(periodInMonths);
	    double emi = (principal * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
	    return BigDecimal.valueOf(emi);
	}
	


}
