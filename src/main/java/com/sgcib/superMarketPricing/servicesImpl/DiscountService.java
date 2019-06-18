package com.sgcib.superMarketPricing.servicesImpl;

import com.sgcib.superMarketPricing.dao.DiscountRepository;
import com.sgcib.superMarketPricing.entities.CartItem;
import com.sgcib.superMarketPricing.entities.Discount;
import com.sgcib.superMarketPricing.entities.Product;
import com.sgcib.superMarketPricing.services.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiscountService implements IDiscountService {

    @Autowired
    DiscountRepository discountRepository;


    @Override
    public CartItem makeDiscountByQuantity(CartItem cartItem, int quantityOfItems, double discountValue) {
        if(cartItem.getQuantity()>quantityOfItems) {
            double amountDiscount = (cartItem.getQuantity() / quantityOfItems) * discountValue;
            double amountWithoutDiscount = (cartItem.getQuantity() % quantityOfItems) * cartItem.getItem().getSellingPrice();
            cartItem.setTotalAmount(amountDiscount + amountWithoutDiscount);
        }
        else{
            double amountWithoutDiscount = (cartItem.getQuantity() % quantityOfItems) * cartItem.getItem().getSellingPrice();
            cartItem.setTotalAmount(amountWithoutDiscount);
        }
        return cartItem;
    }

    @Override
    public CartItem makeDiscountByUnit(CartItem cartItem, int numberOfUnit, double discountValue) {
        if(cartItem.getQuantity()>numberOfUnit) {
            double amountDiscount = (cartItem.getQuantity() / numberOfUnit) * discountValue;
            double amountWithoutDiscount = (cartItem.getQuantity() % numberOfUnit) * cartItem.getItem().getSellingPrice();
            cartItem.setTotalAmount(amountDiscount + amountWithoutDiscount);
        }
        else{
            double amountWithoutDiscount = (cartItem.getQuantity() % numberOfUnit) * cartItem.getItem().getSellingPrice();
            cartItem.setTotalAmount(amountWithoutDiscount);
        }
        return cartItem;
    }

    @Override
    public CartItem makeDiscountByQuantityToGetFree(CartItem cartItem, int quantityOfItems, int itemsOffered) {
        if(cartItem.getQuantity()>quantityOfItems) {
            double amountDiscount = (cartItem.getQuantity() - (cartItem.getQuantity() / quantityOfItems)) * cartItem.getItem().getSellingPrice();
            double amountWithoutDiscount = (cartItem.getQuantity() % quantityOfItems) * cartItem.getItem().getSellingPrice();
            cartItem.setTotalAmount(amountDiscount + amountWithoutDiscount);
        }
        else{
            double amountWithoutDiscount = (cartItem.getQuantity() % quantityOfItems) * cartItem.getItem().getSellingPrice();
            cartItem.setTotalAmount(amountWithoutDiscount);
        }
        return cartItem;
    }
}
