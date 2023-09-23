package com.example.shipping.service;

import com.example.shipping.dto.ProductResponse;
import com.example.shipping.dto.request.ProductRequest;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(Long id);
    void saveProduct(ProductRequest productRequest);
    void updateProduct(ProductRequest productRequest);
    void deleteById(Long id);
    List<ProductResponse> getAll();
}
