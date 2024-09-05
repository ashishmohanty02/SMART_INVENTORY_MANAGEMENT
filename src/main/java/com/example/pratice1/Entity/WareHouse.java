package com.example.pratice1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warehouseId;

    @Column(nullable = false)
    private String warehouseName;

    @Column(nullable = false)
    private String warehouseLocation;

    @OneToMany(mappedBy = "wareHouse",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("wareHouse")
    private List<Inventory> inventory;
}
