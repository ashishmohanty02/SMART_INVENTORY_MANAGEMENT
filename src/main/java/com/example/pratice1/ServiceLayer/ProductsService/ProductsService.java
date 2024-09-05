package com.example.pratice1.ServiceLayer.ProductsService;

import com.example.pratice1.Entity.Category;
import com.example.pratice1.Entity.Inventory;
import com.example.pratice1.Entity.Product;
import com.example.pratice1.Repository.CategoryRepo;
import com.example.pratice1.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService implements ProductsImpl{
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public Product saveProducts(Product product,long categoryId) {
        if(categoryId<=0){
            return productRepo.save(product);
        }
        Category category=categoryRepo.findById(categoryId).orElseThrow(null);
        product.setCategory(category);
        return productRepo.save(product);
    }

    @Override
    public List<Product> sendAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product findProductById(long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }


    @Override
    public Product updateProduct(long productId,Product newProduct) {
        Product oldProduct=productRepo.findById(productId).orElseThrow(null);
        oldProduct.setProductName(newProduct.getProductName());
        oldProduct.setProductPrice(newProduct.getProductPrice());
        oldProduct.setProductDescription(newProduct.getProductDescription());
        Product updatedProduct=productRepo.save(oldProduct);
        return updatedProduct;
    }


    @Override
    public Product updateProductCategory(long productId, long categoryId) {

        Product oldProduct=productRepo.findById(productId).orElse(null);
        Category oldCategory=categoryRepo.findById(categoryId).orElse(null);
        oldProduct.setCategory(oldCategory);
        Product save= productRepo.save(oldProduct);
        return save;

    }

    @Override
    public boolean deleteProductById(long id) {
        Product product=productRepo.findById(id).orElseThrow(null);
        productRepo.deleteById(id);
        if(productRepo.existsById(id))
            return false;
        return true;
    }
}
