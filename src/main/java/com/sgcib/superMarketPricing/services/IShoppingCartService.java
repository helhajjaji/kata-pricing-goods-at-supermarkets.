package com.sgcib.superMarketPricing.services;

import com.sgcib.superMarketPricing.entities.CartItem;
import com.sgcib.superMarketPricing.entities.ShoppingCart;

public interface IShoppingCartService {
     ShoppingCart pay(ShoppingCart shoppingCart);
     ShoppingCart payWithDiscountByQuantity(ShoppingCart shoppingCart, int quantityOfItems, double discountValue);
     ShoppingCart payWithDiscountByUnit(ShoppingCart shoppingCart, int numberOfUnit, double discountValue);
     ShoppingCart payWithDiscountByQuantityToGetFree(ShoppingCart shoppingCart, int quantityOfItems, int itemsOffered);
}
