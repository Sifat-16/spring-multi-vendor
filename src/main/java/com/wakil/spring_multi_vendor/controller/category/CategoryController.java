package com.wakil.spring_multi_vendor.controller.category;

import com.wakil.spring_multi_vendor.model.Category;
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

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody AddCategoryRequest addCategoryRequest){

        try {

            Category category = categoryService.createCategory(addCategoryRequest);

            return ResponseEntity.ok(new ApiResponse("new category created", category));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("category creation failed", e.getMessage()));
        }

    }


    @GetMapping("/all-categories")
    public ResponseEntity<ApiResponse> allCategories(){

        try {

            List<Category> categories = categoryService.allCategories();

            return ResponseEntity.ok(new ApiResponse("all category", categories));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("category failed", e.getMessage()));
        }

    }


    @GetMapping("/get-category/{id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id){

        try {

            Category category = categoryService.getCategoryById(id);

            return ResponseEntity.ok(new ApiResponse("category", category));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("category fetch failed", e.getMessage()));
        }

    }






}
