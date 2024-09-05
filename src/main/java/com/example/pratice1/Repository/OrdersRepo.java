package com.example.pratice1.Repository;

import com.example.pratice1.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
}
