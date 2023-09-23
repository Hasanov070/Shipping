package com.example.shipping.controller;

import com.example.shipping.dto.CartItemResponse;
import com.example.shipping.dto.request.CartItemRequest;
import com.example.shipping.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cartItem")
public class CartItemController {
    final CartItemService cartItemService;

    @GetMapping(value = "/cartItemList")
    public List<CartItemResponse> getCartItemInfo(){
        return cartItemService.gelAll();
    }
    @GetMapping(value = "/getCartItemById/{id}")
    public CartItemResponse getCartItemById(@PathVariable(value = "id")Long id){
        return getCartItemById(id);
    }
    @PostMapping(value = "/saveCartItem")
    public void saveCartItem(@RequestBody CartItemRequest cartItemRequest){
        cartItemService.saveCartItem(cartItemRequest);
    }
    @PostMapping(value = "/updateCartItem")
    public void updateCartItem(@RequestBody CartItemRequest cartItemRequest)
    {
        cartItemService.updateCartItem(cartItemRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id)
    {
        cartItemService.deleteById(id);
    }

}
