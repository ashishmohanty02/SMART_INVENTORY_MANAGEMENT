package com.example.pratice1.ServiceLayer.CategoryService;

import com.example.pratice1.Entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryImple {
    Category saveCategory(Category category);

    List<Category> viewCategory();

    Optional<Category> findCategoryById(long id);

    boolean deleteCategoryById(long id);

    Category updateCategory(long id,Category newCategory);
}
