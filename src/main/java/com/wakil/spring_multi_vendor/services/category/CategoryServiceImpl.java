package com.wakil.spring_multi_vendor.services.category;

import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;

import java.util.*;

public interface CategoryServiceImpl {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> allCategories();
    Category createCategory(AddCategoryRequest addCategoryRequest);

}
