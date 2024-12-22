package com.wakil.spring_multi_vendor.controller.category;

import com.wakil.spring_multi_vendor.model.Category;
import com.wakil.spring_multi_vendor.model.Product;
import com.wakil.spring_multi_vendor.requests.category.AddCategoryRequest;
import com.wakil.spring_multi_vendor.response.ApiResponse;
import com.wakil.spring_multi_vendor.services.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/category")
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;

    @GetMapping("/get-all-category")
    public ResponseEntity<ApiResponse> getAllCategory() {
        try {
            List<Category> all_categories = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse(
                    "all-category",
                    all_categories
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));
        }
    }

    @GetMapping("/category-by-name/{name}")
    public ResponseEntity<ApiResponse> getCategoriesByName(@PathVariable String name) {
        try {
            List<Category> all_categories = categoryService.getCategoryByName(name);
            return ResponseEntity.ok(new ApiResponse(
                    "category-by-name",
                    all_categories
            ));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));
        }
    }

    @GetMapping("category-by-id/{id}")
    public ResponseEntity<ApiResponse> getCategoriesById(@PathVariable Long id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return ResponseEntity.ok(new ApiResponse(
                    "category",
                    category
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", null));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody AddCategoryRequest addCategoryRequest) {
        try {
            Category category = categoryService.createCategory(addCategoryRequest);
            return ResponseEntity.ok(new ApiResponse(
                    "new category",
                    category
            ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("server-error", e.getMessage()));
        }
    }
}