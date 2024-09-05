package com.example.pratice1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierId;

    @Column(nullable = false)
    private String supplierName;

    @Column(nullable = false)
    private String supplierContactNo;

    @OneToMany
    private List<Product> product;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("supplier")
    private List<Orders> orders;

}
