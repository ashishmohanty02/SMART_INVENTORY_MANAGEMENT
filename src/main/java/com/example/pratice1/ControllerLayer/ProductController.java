package com.example.pratice1.ControllerLayer;

import com.example.pratice1.Entity.Product;
import com.example.pratice1.ServiceLayer.ProductsService.ProductsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductsImpl productImpl;

    @PostMapping("/saveProducts/{categoryId}")
    public ResponseEntity<Product> saveProducts(@RequestBody Product product,@PathVariable long categoryId){
        return new ResponseEntity<Product>(productImpl.saveProducts(product,categoryId), HttpStatus.CREATED);
    }
    @GetMapping("/findProductById/{productId}")
    public ResponseEntity<Product> findProductDetailsById(@PathVariable long productId) {
        return new ResponseEntity<>(productImpl.findProductById(productId), HttpStatus.FOUND);
    }

    @GetMapping("/sendAllProducts")
    public ResponseEntity<List<Product>> sendAllProducts(){
        return new ResponseEntity<List<Product>>(productImpl.sendAllProducts(),HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable long productId,@RequestBody Product product){
        return new ResponseEntity<Product>(productImpl.updateProduct(productId,product),HttpStatus.OK);
    }

    @PutMapping("/updateProductCategory/{productId}/{categoryId}")
    public ResponseEntity<Product> updateProductCategoryDetails(@PathVariable long productId,@PathVariable long categoryId,Product newProduct){
        return new ResponseEntity<Product>(productImpl.updateProductCategory(productId,categoryId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteProductById/{productId}")
    public ResponseEntity<Boolean> deleteProductDetailsById(@PathVariable long productId){
        return new ResponseEntity<Boolean>(productImpl.deleteProductById(productId),HttpStatus.GONE);
    }


}
