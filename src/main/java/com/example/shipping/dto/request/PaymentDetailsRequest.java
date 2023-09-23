package com.example.shipping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailsRequest {
    private Long id;
    private Integer amount;
    private String provider;
    private String status;
    private String createdAt;
    private String modifiedAt;


}
