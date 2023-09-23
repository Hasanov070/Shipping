package com.example.shipping.service.impl;

import com.example.shipping.dto.OrderItemsResponse;
import com.example.shipping.dto.request.OrderDetailsRequest;
import com.example.shipping.dto.request.OrderItemsRequest;
import com.example.shipping.model.OrderItems;
import com.example.shipping.repository.OrderItemsRepository;
import com.example.shipping.service.OrderItemsService;
import jakarta.persistence.criteria.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemsImpl implements OrderItemsService {
    final OrderItemsRepository orderItemsRepository;
    @Override
    public OrderItemsResponse getOrderItemsById(Long id) {
        OrderItems orderItems = orderItemsRepository.getOrderItemsById(id);
        return OrderItemsResponse.builder()
                .createdAt(orderItems.getCreatedAt())
                .modifiedAt(orderItems.getModifiedAt())
                .build();
    }

    @Override
    public void saveOrderItems(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = OrderItems.builder()
                .createdAt(orderItemsRequest.getCreatedAt())
                .build();
        orderItemsRepository.save(orderItems);


    }

    @Override
    public void updateOrderItems(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = OrderItems.builder()
                .id(orderItemsRequest.getId())
                .modifiedAt(orderItemsRequest.getModifiedAt())
                .build();
        orderItemsRepository.save(orderItems);

    }



    @Override
    public void deleteById(Long id) {
        if (id == null)
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            orderItemsRepository.deleteById(id);
        }

    }

    @Override
    public List<OrderItemsResponse> getAll() {
        List<OrderItems> orderItems = orderItemsRepository.findAll();
        List<OrderItemsResponse> orderItemsResponses = new ArrayList<>();

        for (OrderItems orderItem : orderItems) {
            OrderItemsResponse orderItemsResponse = OrderItemsResponse.builder()
                    .createdAt(orderItem.getCreatedAt())
                    .modifiedAt(orderItem.getModifiedAt())
                    .build();

            orderItemsResponses.add(orderItemsResponse);

        }
        return orderItemsResponses;
    }
}
