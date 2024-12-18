package com.wakil.spring_multi_vendor.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
