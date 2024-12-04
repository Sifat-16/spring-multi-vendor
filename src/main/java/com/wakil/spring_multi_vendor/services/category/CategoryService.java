package com.wakil.spring_multi_vendor.services.category;

import com.wakil.spring_multi_vendor.exception.category.CategoryNotFoundException;
import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;
import com.wakil.spring_multi_vendor.respository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceImpl {

    final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category Not Found for Id"+id));
    }

    @Override
    public Category getCategoryByName(String name) {
        return Optional.ofNullable(categoryRepository.findByName(name)).orElseThrow(()-> new CategoryNotFoundException("category not found"));
    }

    @Override
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(AddCategoryRequest addCategoryRequest) {
        Category newCategory = addCategoryRequest.createCategory();
        return categoryRepository.save(newCategory);
    }


}
