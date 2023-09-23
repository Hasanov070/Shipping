package com.example.shipping.repository;

import com.example.shipping.model.CartItem;
import com.example.shipping.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    OrderItems getOrderItemsById(Long id);
}
