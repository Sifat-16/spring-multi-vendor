package com.wakil.spring_multi_vendor.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wakil.spring_multi_vendor.model.Category;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long quantity;
    private Category category;
}




