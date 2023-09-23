package com.example.shipping.service.impl;

import com.example.shipping.dto.ShoppingSessionResponse;
import com.example.shipping.dto.request.ShoppingSessionRequest;
import com.example.shipping.model.ShoppingSession;
import com.example.shipping.repository.ShoppingSessionRepository;
import com.example.shipping.service.ShoppingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingSessionImpl implements ShoppingSessionService {
    final ShoppingSessionRepository shoppingSessionRepository;
    @Override
    public ShoppingSessionResponse getShoppingSessionById(Long id) {
        ShoppingSession shoppingSession = shoppingSessionRepository.getShoppingSessionById(id);
        return ShoppingSessionResponse.builder()
                .total(shoppingSession.getTotal())
                .createdAt(shoppingSession.getCreatedAt())
                .modifiedAt(shoppingSession.getModifiedAt())
                .build();
    }

    @Override
    public void saveShoppingSession(ShoppingSessionRequest shoppingSessionRequest) {
        ShoppingSession shoppingSession = ShoppingSession.builder()
                .total(shoppingSessionRequest.getTotal())
                .createdAt(shoppingSessionRequest.getCreatedAt())
                .build();
        shoppingSessionRepository.save(shoppingSession);
    }

    @Override
    public void updateShoppingSession(ShoppingSessionRequest shoppingSessionRequest) {
        ShoppingSession shoppingSession = ShoppingSession.builder()
                .id(shoppingSessionRequest.getId())
                .total(shoppingSessionRequest.getTotal())
                .modifiedAt(shoppingSessionRequest.getModifiedAt())
                .build();
        shoppingSessionRepository.save(shoppingSession);

    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            shoppingSessionRepository.deleteById(id);
        }

    }

    @Override
    public List<ShoppingSessionResponse> getAll() {
        List<ShoppingSession> shoppingSessions = shoppingSessionRepository.findAll();
        List<ShoppingSessionResponse> shoppingSessionResponses = new ArrayList<>();

        for (ShoppingSession shoppingSession : shoppingSessions)
        {
            ShoppingSessionResponse shoppingSessionResponse = ShoppingSessionResponse.builder()
                    .total(shoppingSession.getTotal())
                    .createdAt(shoppingSession.getCreatedAt())
                    .modifiedAt(shoppingSession.getModifiedAt())
                    .build();

            shoppingSessionResponses.add(shoppingSessionResponse);
        }
        return shoppingSessionResponses;
    }

}
