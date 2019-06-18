package com.sgcib.superMarketPricing;

import com.sgcib.superMarketPricing.dao.ProductRepository;
import com.sgcib.superMarketPricing.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperMarketPricingApplication{

	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {

		SpringApplication.run(SuperMarketPricingApplication.class, args);
	}


}
