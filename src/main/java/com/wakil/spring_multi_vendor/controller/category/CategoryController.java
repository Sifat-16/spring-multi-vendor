package com.wakil.spring_multi_vendor.controller.category;

import com.wakil.spring_multi_vendor.services.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class CategoryController {
    final CategoryService categoryService;
}
