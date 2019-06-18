package com.sgcib.superMarketPricing.servicesImpl;

import com.sgcib.superMarketPricing.dao.ShoppingCartRepository;
import com.sgcib.superMarketPricing.entities.CartItem;
import com.sgcib.superMarketPricing.entities.ShoppingCart;
import com.sgcib.superMarketPricing.services.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    DiscountService discountService;

    @Override
    @PostMapping(value="/payWithDiscountByQuantity/{quantityOfItems}/{discountValue}")
    public ShoppingCart payWithDiscountByQuantity(@RequestBody ShoppingCart shoppingCart, @PathVariable(value = "quantityOfItems") int quantityOfItems, @PathVariable(value ="discountValue") double discountValue) {

        List<CartItem> cartItems = shoppingCart.getListItems().stream()
                .peek(c->c=discountService.makeDiscountByQuantity(c,quantityOfItems,discountValue))
                .collect(Collectors.toList());
        shoppingCart.setListItems(cartItems);
        return  shoppingCart;
    }

    @Override
    @PostMapping(value="/payWithDiscountByQuantity/{numberOfUnit}/{discountValue}")
    public ShoppingCart payWithDiscountByUnit(@RequestBody ShoppingCart shoppingCart,@PathVariable(value = "numberOfUnit") int numberOfUnit,@PathVariable(value = "discountValue") double discountValue) {
        List<CartItem> cartItems = shoppingCart.getListItems().stream()
                .peek(c->c=discountService.makeDiscountByUnit(c,numberOfUnit,discountValue))
                .collect(Collectors.toList());
        shoppingCart.setListItems(cartItems);
        return  shoppingCart;
    }

    @Override
    @PostMapping(value="/payWithDiscountByQuantityToGetFree/{quantityOfItems}/{itemsOffered}")
    public ShoppingCart payWithDiscountByQuantityToGetFree(@RequestBody ShoppingCart shoppingCart,@PathVariable(value ="quantityOfItems") int quantityOfItems, @PathVariable(value ="itemsOffered") int itemsOffered) {
        List<CartItem> cartItems = shoppingCart.getListItems().stream()
                .peek(c->c=discountService.makeDiscountByQuantityToGetFree(c,quantityOfItems,itemsOffered))
                .collect(Collectors.toList());
        shoppingCart.setListItems(cartItems);
        return  shoppingCart;
    }

    @Override
    @PostMapping(value="/pay")
    public ShoppingCart pay(@RequestBody ShoppingCart shoppingCart) {
        List<CartItem> cartItemsWithoutDiscount = shoppingCart.getListItems().stream()
                .filter(c -> c.getItem().getDiscountLabel().equals("No Discount"))
                .peek(c->c.setTotalAmount(c.getQuantity()*c.getItem().getSellingPrice()))
                .collect(Collectors.toList());
        shoppingCart.setListItems(cartItemsWithoutDiscount);
        return  shoppingCart;

    }
}
