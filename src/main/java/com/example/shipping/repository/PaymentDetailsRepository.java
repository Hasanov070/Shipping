package com.example.shipping.repository;

import com.example.shipping.model.CartItem;
import com.example.shipping.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {
    PaymentDetails getPaymentDetailsById(Long id);
}
