package com.example.shipping.service.impl;

import com.example.shipping.dto.CartItemResponse;
import com.example.shipping.dto.request.CartItemRequest;
import com.example.shipping.model.CartItem;
import com.example.shipping.repository.CartItemRepository;
import com.example.shipping.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CartItemImpl implements CartItemService {
    final CartItemRepository cartItemRepository;
    @Override
    public CartItemResponse getCartItemsById(Long id) {
        CartItem cartItem = cartItemRepository.getCartItemById(id);
        return CartItemResponse.builder()
                .quantity(cartItem.getQuantity())
                .createdAt(cartItem.getCreatedAt())
                .modifiedAt(cartItem.getModifiedAt())
                .build();
    }

    @Override
    public void saveCartItem(CartItemRequest cartItemRequest) {
        CartItem cartItem = CartItem.builder()
                .quantity(cartItemRequest.getQuantity())
                .createdAt(cartItemRequest.getModifiedAt())
                .build();
        cartItemRepository.save(cartItem);

    }

    @Override
    public void updateCartItem(CartItemRequest cartItemRequest) {
        CartItem cartItem = CartItem.builder()
                .id(cartItemRequest.getId())
                .quantity(cartItemRequest.getQuantity())
                .modifiedAt(cartItemRequest.getModifiedAt())
                .build();

    }

    @Override
    public void deleteById(Long id) {
        if(id == null)
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            cartItemRepository.deleteById(id);
        }

    }

    @Override
    public List<CartItemResponse> gelAll() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        List<CartItemResponse> cartItemResponses = new ArrayList<>();

        for (CartItem cartItem : cartItems){
            CartItemResponse cartItemResponse = CartItemResponse.builder()
                    .quantity(cartItem.getQuantity())
                    .createdAt(cartItem.getCreatedAt())
                    .modifiedAt(cartItem.getModifiedAt())
                    .build();
            cartItemResponses.add(cartItemResponse);
        }
        return cartItemResponses;
    }
}
