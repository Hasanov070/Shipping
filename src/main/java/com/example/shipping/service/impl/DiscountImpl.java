package com.example.shipping.service.impl;

import com.example.shipping.dto.DiscountResponse;
import com.example.shipping.dto.request.DiscountRequest;
import com.example.shipping.model.Discount;
import com.example.shipping.repository.DiscountRepository;
import com.example.shipping.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountImpl implements DiscountService {
    final DiscountRepository discountRepository;


    @Override
    public DiscountResponse getDiscountById(Long id) {
        Discount discount = discountRepository.getDiscountById(id);
        return  DiscountResponse.builder()
                .name(discount.getName())
                .desc(discount.getDesc())
                .discountPercent(discount.getDiscountPercent())
                .build();
    }

    @Override
    public void saveDiscount(DiscountRequest discountRequest) {
        Discount discount = Discount.builder()
                .name(discountRequest.getName())
                .desc(discountRequest.getDesc())
                .discountPercent(discountRequest.getDiscountPercent())
                .createdAt(discountRequest.getCreatedAt())
                .build();
        discountRepository.save(discount);

    }

    @Override
    public void updateDiscount(DiscountRequest discountRequest) {
        Discount discount = Discount.builder()
                .id(discountRequest.getId())
                .name(discountRequest.getName())
                .desc(discountRequest.getDesc())
                .discountPercent(discountRequest.getDiscountPercent())
                .modifiedAt(discountRequest.getModifiedAt())
                .build();
        discountRepository.save(discount);

    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
        {
            throw new RuntimeException("There is no such information");

        }
        else {
            discountRepository.deleteById(id);
        }

    }

    @Override
    public List<DiscountResponse> getAll() {
        List<Discount> discounts = discountRepository.findAll();
        List<DiscountResponse> discountResponses = new ArrayList<>();

        for (Discount discount : discounts)
        {
            DiscountResponse discountResponse = DiscountResponse.builder()
                    .name(discount.getName())
                    .desc(discount.getDesc())
                    .discountPercent(discount.getDiscountPercent())
                    .createdAt(discount.getCreatedAt())
                    .modifiedAt(discount.getModifiedAt())
                    .build();

            discountResponses.add(discountResponse);
        }
        return discountResponses;
    }
}
