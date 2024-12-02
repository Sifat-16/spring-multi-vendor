package com.wakil.spring_multi_vendor.services.product;

import com.wakil.spring_multi_vendor.exception.product.ProductNotFoundException;
import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.product.AddProductRequest;
import com.wakil.spring_multi_vendor.respository.product.ProductRepository;
import dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceImpl {

    final ProductRepository productRepository;

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id).map(Product::createProductDto).orElseThrow(()-> new ProductNotFoundException("Product Not Found"));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(Product::createProductDto).toList();
    }

    @Override
    public ProductDto createProduct(AddProductRequest addProductRequest) {
        if(addProductRequest.getName()==null){
            throw new RuntimeException("You haven't added the name MF!!!!");
        }
        Product savedProduct = addProductRequest.createProduct();

        return productRepository.save(savedProduct).createProductDto();
    }

    @Override
    public List<ProductDto> getProductByName(String name) {
        return productRepository.findAllByName(name).stream().map(Product::createProductDto).toList();
    }

    @Override
    public List<ProductDto> getProductByNameOrPrice(String name, double price) {
        return productRepository.findAllByNameOrPrice(name, price).stream().map(Product::createProductDto).toList();
    }
}
