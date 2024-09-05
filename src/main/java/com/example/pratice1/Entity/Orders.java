package com.example.pratice1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(nullable = true)
    private LocalDateTime orderDate;

    @Column(nullable = true)
    private LocalDateTime deliveryDate;

    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER,orphanRemoval = true)
    @JsonIgnoreProperties("order")
    private List<OrderItem> orderItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("order")
    private Supplier supplier;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("order")
    private Transaction transaction;

}
