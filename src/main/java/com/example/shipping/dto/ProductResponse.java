package com.example.shipping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String name;
    private String desc;
    private String SKU;
    private String category;
    private Integer price;
    private String createdAt;
    private String modifiedAt;
}
