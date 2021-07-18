package com.sandeep.microservice.loanservice.proxy;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sandeep.microservice.loanservice.model.Product;

@FeignClient(name="quote-service",path="quote")
public interface QuoteServiceProxy {
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> retrieveLoanProducts() ;
	
	@GetMapping("product/{productId}")
	public ResponseEntity<Product> retrieveLoanProductByProductId(@PathVariable String productId );
	
	@GetMapping("interestRate/{productId}")
	public ResponseEntity<BigDecimal>  getInterestRateByProduct(@PathVariable String productId );
	

}
