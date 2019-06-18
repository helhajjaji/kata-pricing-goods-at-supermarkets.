package com.sgcib.superMarketPricing.dao;

import com.sgcib.superMarketPricing.entities.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
