package com.wakil.spring_multi_vendor.services.category;

import com.wakil.spring_multi_vendor.exception.category.CategoryNotFoundException;
import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;
import com.wakil.spring_multi_vendor.respository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceImpl {

    final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(AddCategoryRequest addCategoryRequest) {
        if(addCategoryRequest.getTitle() == null) {
            throw new RuntimeException("You haven't added any Category!");
        }
        Category savedCategory = addCategoryRequest.createCategory();
        return categoryRepository.save(savedCategory);
    }

    @Override
    public List<Category> getCategoryByName(String title) {
        return categoryRepository.findAllByTitle(title);
    }
}