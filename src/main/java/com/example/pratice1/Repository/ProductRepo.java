package com.example.pratice1.Repository;

import com.example.pratice1.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
//    Category findByCategory(long id);
}
