package com.example.shipping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingSessionRequest {
    private Long id;
    private String total;
    private String createdAt;
    private String modifiedAt;
}
