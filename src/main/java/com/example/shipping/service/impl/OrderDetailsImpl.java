package com.example.shipping.service.impl;

import com.example.shipping.dto.DiscountResponse;
import com.example.shipping.dto.OrderDetailsResponse;
import com.example.shipping.dto.OrderItemsResponse;
import com.example.shipping.dto.request.DiscountRequest;
import com.example.shipping.dto.request.OrderDetailsRequest;
import com.example.shipping.model.Discount;
import com.example.shipping.model.OrderDetails;
import com.example.shipping.model.OrderItems;
import com.example.shipping.repository.DiscountRepository;
import com.example.shipping.repository.OrderDetailsRepository;
import com.example.shipping.repository.OrderItemsRepository;
import com.example.shipping.service.DiscountService;
import com.example.shipping.service.OrderDetailsService;
import com.example.shipping.service.OrderItemsService;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsImpl implements OrderDetailsService {
    final OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetailsResponse getOrderDetailsById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);
        return OrderDetailsResponse.builder()
                .total(orderDetails.getTotal())
                .createdAt(orderDetails.getCreatedAt())
                .modifiedAt(orderDetails.getModifiedAt())
                .build();
    }

    @Override
    public void saveOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .id(orderDetailsRequest.getId())
                .total(orderDetailsRequest.getTotal())
                .modifiedAt(orderDetailsRequest.getModifiedAt())
                .build();
        orderDetailsRepository.save(orderDetails);

    }

    @Override
    public void updateOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .id(orderDetailsRequest.getId())
                .total(orderDetailsRequest.getTotal())
                .modifiedAt(orderDetailsRequest.getModifiedAt())
                .build();
        orderDetailsRepository.save(orderDetails);

    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            orderDetailsRepository.deleteById(id);
        }

    }

    @Override
    public List<OrderDetailsResponse> getAll() {
        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<OrderDetailsResponse> orderDetailsResponses = new ArrayList<>();

        for (OrderDetails orderDetails1 : orderDetails){
            OrderDetailsResponse orderDetailsResponse = OrderDetailsResponse.builder()
                    .total(orderDetails1.getTotal())
                    .createdAt(orderDetails1.getCreatedAt())
                    .modifiedAt(orderDetails1.getModifiedAt())
                    .build();
            orderDetailsResponses.add(orderDetailsResponse);
        }
        return orderDetailsResponses;
    }
}
