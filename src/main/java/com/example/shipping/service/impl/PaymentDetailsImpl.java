package com.example.shipping.service.impl;

import com.example.shipping.dto.PaymentDetailsResponse;
import com.example.shipping.dto.request.PaymentDetailsRequest;
import com.example.shipping.model.PaymentDetails;
import com.example.shipping.repository.PaymentDetailsRepository;
import com.example.shipping.service.PaymentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentDetailsImpl implements PaymentDetailsService {
    final PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetailsResponse getPaymentDetailsById(Long id) {
        PaymentDetails paymentDetails = paymentDetailsRepository.getPaymentDetailsById(id);
        return PaymentDetailsResponse.builder()
                .amount(paymentDetails.getAmount())
                .provider(paymentDetails.getProvider())
                .status(paymentDetails.getStatus())
                .createdAt(paymentDetails.getCreatedAt())
                .modifiedAt(paymentDetails.getModifiedAt())
                .build();
    }

    @Override
    public void savePaymentDetails(PaymentDetailsRequest paymentDetailsRequest) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .amount(paymentDetailsRequest.getAmount())
                .provider(paymentDetailsRequest.getProvider())
                .status(paymentDetailsRequest.getStatus())
                .createdAt(paymentDetailsRequest.getCreatedAt())
                .build();
        paymentDetailsRepository.save(paymentDetails);


    }

    @Override
    public void updatePaymentDetails(PaymentDetailsRequest paymentDetailsRequest) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .id(paymentDetailsRequest.getId())
                .amount(paymentDetailsRequest.getAmount())
                .provider(paymentDetailsRequest.getProvider())
                .status(paymentDetailsRequest.getStatus())
                .createdAt(paymentDetailsRequest.getCreatedAt())
                .build();
        paymentDetailsRepository.save(paymentDetails);

    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
        {
            throw new RuntimeException("There is no such information");
        }
        else {
            paymentDetailsRepository.deleteById(id);
        }

    }

    @Override
    public List<PaymentDetailsResponse> getAll() {
        List<PaymentDetails> paymentDetails = paymentDetailsRepository.findAll();
        List<PaymentDetailsResponse> paymentDetailsResponses = new ArrayList<>();

        for (PaymentDetails paymentDetails1 : paymentDetails){
            PaymentDetailsResponse paymentDetailsResponse = PaymentDetailsResponse.builder()
                    .amount(paymentDetails1.getAmount())
                    .provider(paymentDetails1.getProvider())
                    .status(paymentDetails1.getStatus())
                    .createdAt(paymentDetails1.getCreatedAt())
                    .modifiedAt(paymentDetails1.getModifiedAt())
                    .build();
            paymentDetailsResponses.add(paymentDetailsResponse);
        }
        return  paymentDetailsResponses;
    }
}
