package com.example.shipping.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Long id;
    private String name;
    private String desc;
    private String SKU;
    private String category;
    private Integer price;
    private String createdAt;
    private String modifiedAt;

}
