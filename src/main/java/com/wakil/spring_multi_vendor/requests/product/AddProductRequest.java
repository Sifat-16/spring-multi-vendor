package com.wakil.spring_multi_vendor.requests.product;


import com.wakil.spring_multi_vendor.model.Product;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    private String name;
    private String description;
    private double price;
    private Long quantity;


    public Product createProduct(){
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .quantity(this.quantity)
                .build();

    }

}
