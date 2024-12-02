package com.wakil.spring_multi_vendor.model;

import dto.product.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long quantity;

    public ProductDto createProductDto(){
        return ProductDto.builder()
                .id(this.id)
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .build();
    }
}
