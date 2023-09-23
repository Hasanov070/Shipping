package com.example.shipping.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequest {
    private Long id;
    private String name;
    private String desc;
    private Integer discountPercent;
    private String createdAt;
    private String modifiedAt;
}
