package com.ldb.controller;

import com.ldb.pojo.ResultData;
import com.ldb.pojo.ShoppingCart;
import com.ldb.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2024/01/01 23:12
 **/
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @PostMapping
    public ResultData addShoppingCar(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.addShoppingCar(shoppingCart);
    }

    @GetMapping("{userId}")
    public ResultData getShoppingCart(@PathVariable int userId){
        return shoppingCartService.selectShoppingCart(userId);
    }
    @DeleteMapping("{cartId}")
    public ResultData deleteShoppingCart(@PathVariable int cartId){
        return shoppingCartService.deleteShoppingCart(cartId);
    }
    @DeleteMapping
    public ResultData deleteShoppingCartBySelect(@RequestBody ShoppingCart[] shoppingCarts){
        return shoppingCartService.deleteShoppingCartBySelect(shoppingCarts);
    }
}
