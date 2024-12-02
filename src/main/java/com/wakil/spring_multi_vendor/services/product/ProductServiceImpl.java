package com.wakil.spring_multi_vendor.services.product;

import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.product.AddProductRequest;
import dto.product.ProductDto;

import java.util.List;

public interface ProductServiceImpl {
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
    ProductDto createProduct(AddProductRequest addProductRequest);
    List<ProductDto> getProductByName(String name);
    List<ProductDto> getProductByNameOrPrice(String name, double price);
}
