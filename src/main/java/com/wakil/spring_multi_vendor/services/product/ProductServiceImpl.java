package com.wakil.spring_multi_vendor.services.product;

import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.product.AddProductRequest;

import java.util.List;

public interface ProductServiceImpl {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(AddProductRequest addProductRequest);
    List<Product> getProductByName(String name);
}
