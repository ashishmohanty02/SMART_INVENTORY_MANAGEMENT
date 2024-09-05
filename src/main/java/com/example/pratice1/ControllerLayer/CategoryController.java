package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.Category;
import com.example.pratice1.Response.ApiResponse;
import com.example.pratice1.ServiceLayer.CategoryService.CategoryImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryImple categoryImple;


    @PostMapping("/saveCategory")
    public ResponseEntity<ApiResponse> saveCategoryDetails(@RequestBody Category category){
        Category category1 = categoryImple.saveCategory(category);
        if(category1!=null){
            ApiResponse categoryCreatedSuccessfully = ApiResponse.builder().message("category created successfully").status(true).httpStatuscode(HttpStatus.CREATED).build();
            return new ResponseEntity<>(categoryCreatedSuccessfully,HttpStatus.CREATED);
        }

            ApiResponse categoryCreatedSuccessfully = ApiResponse.builder().message("category cannot be created successfully").status(false).httpStatuscode(HttpStatus.EXPECTATION_FAILED).build();
            return new ResponseEntity<>(categoryCreatedSuccessfully,HttpStatus.EXPECTATION_FAILED);


    }
    @GetMapping("/viewAllCategory")
    public ResponseEntity<List<Category>> sendCategory(){
        return new ResponseEntity<List<Category>>(categoryImple.viewCategory(),HttpStatus.OK);
    }
    @GetMapping("/findCategoryById/{id}")
    public ResponseEntity<Optional<Category>> findCategoryDetailsById(@PathVariable long id){
        return new ResponseEntity<Optional<Category>>(categoryImple.findCategoryById(id),HttpStatus.FOUND);
    }


    @DeleteMapping("/deleteCategoryById/{id}")
    public boolean deleteCategoryById(@PathVariable long id){
        return categoryImple.deleteCategoryById(id);
  }

  @PutMapping("/updateCategoryById/{id}")
    public ResponseEntity<Category> updateCategoryDetails(@PathVariable long id,@RequestBody Category category){
        return new ResponseEntity<Category>(categoryImple.updateCategory(id,category),HttpStatus.OK);
  }
}
