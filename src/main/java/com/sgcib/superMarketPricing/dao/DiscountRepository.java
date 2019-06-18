package com.sgcib.superMarketPricing.dao;

import com.sgcib.superMarketPricing.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    public Discount findByType(String type);
}
