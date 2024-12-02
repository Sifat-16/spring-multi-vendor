package com.wakil.spring_multi_vendor.services.product;

import com.wakil.spring_multi_vendor.exception.product.ProductNotFoundException;
import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.product.AddProductRequest;
import com.wakil.spring_multi_vendor.respository.product.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceImpl {

    final ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(AddProductRequest addProductRequest) {
        if(addProductRequest.getName()==null){
            throw new RuntimeException("You haven't added the name MF!!!!");
        }
        Product savedProduct = addProductRequest.createProduct();
        return productRepository.save(savedProduct);
    }

    @Override
    public List<Product> getProductByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public Product getProductByPrice(String price) {
        return productRepository.findByPrice(price);
    }
}
