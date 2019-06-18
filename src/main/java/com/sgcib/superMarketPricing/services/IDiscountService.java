package com.sgcib.superMarketPricing.services;

import com.sgcib.superMarketPricing.entities.CartItem;
import com.sgcib.superMarketPricing.entities.Discount;
import com.sgcib.superMarketPricing.entities.Product;

public interface IDiscountService {
     CartItem makeDiscountByQuantity(CartItem cartItem, int quantityOfItems, double discountValue);
     CartItem makeDiscountByUnit(CartItem cartItem, int numberOfUnit, double discountValue);
     CartItem makeDiscountByQuantityToGetFree(CartItem cartItem, int quantityOfItems, int itemsOffered);
}
