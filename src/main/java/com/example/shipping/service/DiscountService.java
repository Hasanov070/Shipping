package com.example.shipping.service;

import com.example.shipping.dto.DiscountResponse;
import com.example.shipping.dto.request.DiscountRequest;

import java.util.List;

public interface DiscountService {
    DiscountResponse getDiscountById(Long id);
    void saveDiscount(DiscountRequest discountRequest);
    void updateDiscount(DiscountRequest discountRequest);
    void deleteById(Long id);
    List<DiscountResponse> getAll();
}
