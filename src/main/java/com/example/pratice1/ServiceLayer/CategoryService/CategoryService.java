package com.example.pratice1.ServiceLayer.CategoryService;

import com.example.pratice1.Entity.Category;
import com.example.pratice1.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryImple{
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> viewCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findCategoryById(long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public boolean deleteCategoryById(long id) {
        Category findid=categoryRepo.findById(id).orElseThrow(null);
        categoryRepo.deleteById(id);
        if(categoryRepo.existsById(id))
            return false;
        return true;
    }

    @Override
    public Category updateCategory(long id, Category newCategory) {
        Category oldCategory=categoryRepo.findById(id).orElseThrow(null);
        oldCategory.setCategoryName(newCategory.getCategoryName());
        categoryRepo.save(oldCategory);
        return oldCategory;
    }
}
