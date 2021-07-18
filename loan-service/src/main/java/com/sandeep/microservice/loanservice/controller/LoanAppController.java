package com.sandeep.microservice.loanservice.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sandeep.microservice.loanservice.configuration.LoanConfiguration;
import com.sandeep.microservice.loanservice.model.Product;
import com.sandeep.microservice.loanservice.model.Quote;
import com.sandeep.microservice.loanservice.model.QuoteRequest;
import com.sandeep.microservice.loanservice.proxy.QuoteServiceProxy;
import com.sandeep.microservice.loanservice.utility.LoanServiceUtils;

@RestController
@RequestMapping("loan")
public class LoanAppController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	QuoteServiceProxy quoteServiceProxy;

	@Autowired
	LoanConfiguration loanConfig;


	@GetMapping("properties")
	Map<String, String> getProperties() {
		Map<String, String> map = new HashMap<>();
		map.put("property-1", loanConfig.getProperty1());
		map.put("property-2", loanConfig.getProperty2());
		map.put("property-3", loanConfig.getProperty3());
		return map;

	}

	@GetMapping("products")
	public ResponseEntity<List<Product>> getProducts() {
		ResponseEntity<List<Product>> retrieveLoanProducts = quoteServiceProxy
				.retrieveLoanProducts();
		return retrieveLoanProducts;
	}

	@GetMapping("product/{productId}")
	ResponseEntity<Product> getProductByProductId(@PathVariable String productId) {
		ResponseEntity<Product> productReponse = quoteServiceProxy
				.retrieveLoanProductByProductId(productId);
		return productReponse;
	}

	@PostMapping("quote")
	public ResponseEntity<Quote> getQuote(@RequestBody QuoteRequest loanRequest) {

		ResponseEntity<BigDecimal> interestRateResponse = quoteServiceProxy
				.getInterestRateByProduct(loanRequest.getProductId());
		HttpHeaders header1 = interestRateResponse.getHeaders();

		BigDecimal interestRate = interestRateResponse.getBody();
		ResponseEntity<Product> productReponse = quoteServiceProxy
				.retrieveLoanProductByProductId(loanRequest.getProductId());
		HttpHeaders header2 = productReponse.getHeaders();

		Product product = productReponse.getBody();
		BigDecimal calculatedEmi = LoanServiceUtils.emiCalculator(loanRequest.getLoanAmount(),
				interestRate, loanRequest.getPeriodInMonths());
		Quote quote = new Quote(product.getProductId(), product.getProductName(),
				loanRequest.getLoanAmount(), loanRequest.getPeriodInMonths(), interestRate,
				calculatedEmi);
		return ResponseEntity.ok().headers(header1).headers(header2).body(quote);
	}

	public String fallbackResponse(Exception ex) {

		return "Service unavailable at this moment !" + ex.getMessage();

	}

}
