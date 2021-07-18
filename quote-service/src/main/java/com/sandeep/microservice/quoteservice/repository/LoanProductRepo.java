package com.sandeep.microservice.quoteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.microservice.quoteservice.model.LoanProduct;

public interface LoanProductRepo extends JpaRepository<LoanProduct, Long>{
	public LoanProduct findByProductId(String productId);
}
