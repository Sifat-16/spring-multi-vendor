package com.wakil.spring_multi_vendor.requests.product;


import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    private String name;
    private String description;
    private double price;
    private Long quantity;
    private Long categoryId;


    public Product createProduct() {
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .quantity(this.quantity)
                .build();
    }

}
