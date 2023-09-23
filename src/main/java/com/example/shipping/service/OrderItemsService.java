package com.example.shipping.service;

import com.example.shipping.dto.OrderItemsResponse;
import com.example.shipping.dto.request.OrderDetailsRequest;
import com.example.shipping.dto.request.OrderItemsRequest;

import java.util.List;

public interface OrderItemsService {
    OrderItemsResponse getOrderItemsById(Long id);
    void saveOrderItems(OrderItemsRequest orderItemsRequest);
    void updateOrderItems(OrderItemsRequest orderItemsRequest);
    void deleteById(Long id);
    List<OrderItemsResponse> getAll();
}
