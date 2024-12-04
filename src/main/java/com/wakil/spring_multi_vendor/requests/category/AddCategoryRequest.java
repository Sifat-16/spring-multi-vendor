package com.wakil.spring_multi_vendor.requests.category;

import com.wakil.spring_multi_vendor.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryRequest {
    private String title;
    private String description;

    public Category createCategory() {
        return Category.builder()
                .title(this.title)
                .description(this.description)
                .build();
    }
}
