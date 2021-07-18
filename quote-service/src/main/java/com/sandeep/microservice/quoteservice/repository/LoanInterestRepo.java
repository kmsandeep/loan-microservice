package com.sandeep.microservice.quoteservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.microservice.quoteservice.model.LoanInterest;

public interface LoanInterestRepo extends JpaRepository<LoanInterest, Long>{
   public LoanInterest findByProductId(String productId);
}
