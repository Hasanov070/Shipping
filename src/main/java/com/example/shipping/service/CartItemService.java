package com.example.shipping.service;

import com.example.shipping.dto.CartItemResponse;
import com.example.shipping.dto.request.CartItemRequest;

import java.util.List;

public interface CartItemService {
    CartItemResponse getCartItemsById(Long id);

    void saveCartItem(CartItemRequest cartItemRequest);

    void updateCartItem(CartItemRequest cartItemRequest);
    void deleteById(Long id);
    List<CartItemResponse> gelAll();
}
