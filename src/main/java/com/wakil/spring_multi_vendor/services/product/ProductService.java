package com.wakil.spring_multi_vendor.services.product;

import com.wakil.spring_multi_vendor.dto.product.ProductDto;
import com.wakil.spring_multi_vendor.exception.product.ProductNotFoundException;
import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;
import com.wakil.spring_multi_vendor.requests.product.AddProductRequest;
import com.wakil.spring_multi_vendor.respository.product.ProductRepository;
import com.wakil.spring_multi_vendor.services.category.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceImpl {

    final ProductRepository productRepository;
    final CategoryService categoryService;
    final ModelMapper modelMapper;

    @Override
    public ProductDto getProductById(Long id) {
        return convertToDto(productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Not Found")));
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public ProductDto createProduct(AddProductRequest addProductRequest) {

        if(addProductRequest.getName()==null){
            throw new RuntimeException("You haven't added the name MF!!!!");
        }

        Product savedProduct = addProductRequest.createProduct();
        if(addProductRequest.getCategoryId()!=null){
            Category category = categoryService.getCategoryById(addProductRequest.getCategoryId());
            savedProduct.setCategory(category);
        }


        return convertToDto(productRepository.save(savedProduct));
    }

    @Override
    public List<ProductDto> getProductByName(String name) {
        return productRepository.findAllByName(name).stream().map(this::convertToDto).toList();
    }

    @Override
    public List<ProductDto> getProductByPriceRange(double minPrice) {
        return productRepository.findAllByMinPrice(minPrice).stream().map(this::convertToDto).toList();
    }

    public ProductDto convertToDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }


}
