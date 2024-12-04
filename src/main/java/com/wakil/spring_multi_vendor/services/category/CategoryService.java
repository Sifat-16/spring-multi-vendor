package com.wakil.spring_multi_vendor.services.category;

import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceImpl {

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category createCategory(AddCategoryRequest addCategoryRequest) {
        return null;
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        return List.of();
    }
}
