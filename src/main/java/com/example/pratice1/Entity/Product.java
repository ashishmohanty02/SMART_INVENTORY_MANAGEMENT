package com.example.pratice1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double productPrice;

    @Column(nullable = false)
    private String productDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("products")
    private Category category;


    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("product")
    private List<Inventory> inventory;


}
