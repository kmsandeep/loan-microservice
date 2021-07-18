package com.sandeep.microservice.quoteservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.microservice.quoteservice.configuration.QuoteConfiguration;
import com.sandeep.microservice.quoteservice.model.LoanInterest;
import com.sandeep.microservice.quoteservice.model.LoanProduct;
import com.sandeep.microservice.quoteservice.repository.LoanInterestRepo;
import com.sandeep.microservice.quoteservice.repository.LoanProductRepo;

@RestController
@RequestMapping("quote")
public class QuoteController {
	@Autowired
	LoanInterestRepo loanInterestRepo;
	
	@Autowired
	LoanProductRepo loanProductRepo;
	
	@Autowired
	Environment environment;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	QuoteConfiguration quoteConfig;
	
	@GetMapping("properties")
	Map<String, String> getProperties() {
		Map<String, String> map = new HashMap<>();
		map.put("property-1", quoteConfig.getProperty1());
		map.put("property-2", quoteConfig.getProperty2());
		map.put("property-3", quoteConfig.getProperty3());
		return map;

	}
	@GetMapping("products")
	public ResponseEntity<List<LoanProduct>> retrieveLoanProducts() {
		
		String port = environment.getProperty("local.server.port");
		List<LoanProduct> loanProducts = loanProductRepo.findAll();
		
		return ResponseEntity.ok().header("server.port", port).body(loanProducts);
	}
	@GetMapping("product/{productId}")
	public ResponseEntity<LoanProduct> retrieveLoanProductByProductId(@PathVariable String productId ) {
		String port = environment.getProperty("local.server.port");
		LoanProduct product = loanProductRepo.findByProductId(productId);
		return ResponseEntity.ok().header("product.server.port", port).body(product);
	}
	
	@GetMapping("interestRate/{productId}")
	public ResponseEntity<BigDecimal> getInterestRateByProduct(@PathVariable String productId ) {
		String port = environment.getProperty("local.server.port");
		LoanInterest loanInterest = loanInterestRepo.findByProductId(productId);
		return ResponseEntity.ok().header("rate.server.port", port).body(loanInterest.getInterestRate());
	}

}
