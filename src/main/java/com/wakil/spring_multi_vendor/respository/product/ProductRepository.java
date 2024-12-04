package com.wakil.spring_multi_vendor.respository.product;

import com.wakil.spring_multi_vendor.dto.product.ProductDto;
import com.wakil.spring_multi_vendor.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);

    @Query(value = "SELECT p FROM Product p WHERE p.price >= :minPrice")
    List<Product> findAllByMinPrice(@Param("minPrice") double minPrice);
}
