package com.wakil.spring_multi_vendor.respository.product;

import com.wakil.spring_multi_vendor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
    Product findByPrice(String price);
}
