package com.example.shipping.service;

import com.example.shipping.dto.ShoppingSessionResponse;
import com.example.shipping.dto.request.ShoppingSessionRequest;
import com.example.shipping.model.ShoppingSession;

import java.util.List;

public interface ShoppingSessionService {
    ShoppingSessionResponse getShoppingSessionById(Long id);
    void saveShoppingSession(ShoppingSessionRequest shoppingSessionRequest);
    void updateShoppingSession(ShoppingSessionRequest shoppingSessionRequest);
    void deleteById(Long id);
    List<ShoppingSessionResponse> getAll();

}
