package com.wakil.spring_multi_vendor.requests.category;

import com.wakil.spring_multi_vendor.model.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCategoryRequest {
    private String name;
    private String description;


    public Category createCategory(){

        return Category.builder()
                .name(this.name)
                .description(this.description)
                .build();

    }

}
