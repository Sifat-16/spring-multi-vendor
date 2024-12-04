package com.wakil.spring_multi_vendor.respository.category;

import com.wakil.spring_multi_vendor.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByTitle(String name);
}
