package com.example.shipping.service;

import com.example.shipping.dto.OrderDetailsResponse;
import com.example.shipping.dto.request.OrderDetailsRequest;

import java.util.List;

public interface OrderDetailsService {
    OrderDetailsResponse getOrderDetailsById(Long id);
    void saveOrderDetails(OrderDetailsRequest orderDetailsRequest);
    void updateOrderDetails(OrderDetailsRequest orderDetailsRequest);
    void deleteById(Long id);
    List<OrderDetailsResponse> getAll();

}
