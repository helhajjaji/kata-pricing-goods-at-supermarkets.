package com.sgcib.superMarketPricing.dao;

import com.sgcib.superMarketPricing.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
