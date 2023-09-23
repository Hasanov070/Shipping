package com.example.shipping.service;

import com.example.shipping.dto.PaymentDetailsResponse;
import com.example.shipping.dto.request.PaymentDetailsRequest;

import java.util.List;

public interface PaymentDetailsService {
    PaymentDetailsResponse getPaymentDetailsById(Long id);
    void savePaymentDetails(PaymentDetailsRequest paymentDetailsRequest);
    void updatePaymentDetails(PaymentDetailsRequest paymentDetailsRequest);
    void deleteById(Long id);
    List<PaymentDetailsResponse> getAll();

}
