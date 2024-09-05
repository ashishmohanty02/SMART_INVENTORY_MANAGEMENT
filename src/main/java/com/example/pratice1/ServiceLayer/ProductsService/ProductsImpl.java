package com.example.pratice1.ServiceLayer.ProductsService;

import com.example.pratice1.Entity.Inventory;
import com.example.pratice1.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsImpl {
   public Product saveProducts(Product product,long categoryId);

   public List<Product> sendAllProducts();
   public Product findProductById(long id);
   public Product updateProduct(long productId,Product newProduct);
   public Product updateProductCategory(long productId, long categoryId);


   public boolean deleteProductById(long id);
}
