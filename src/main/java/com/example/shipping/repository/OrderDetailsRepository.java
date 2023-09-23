package com.example.shipping.repository;

import com.example.shipping.model.OrderDetails;
import com.example.shipping.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    OrderDetails getOrderDetailsById(Long id);

}
