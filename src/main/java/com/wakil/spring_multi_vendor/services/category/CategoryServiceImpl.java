package com.wakil.spring_multi_vendor.services.category;

import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;

import java.util.List;

public interface CategoryServiceImpl {
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category createCategory(AddCategoryRequest addCategoryRequest);
    List<Category> getCategoryByName(String name);
}