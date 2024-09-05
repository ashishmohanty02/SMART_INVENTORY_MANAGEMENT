package com.example.pratice1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @Column(nullable = false)
    private LocalDateTime transactionTime;

    @Column(nullable = false)
    private double transactionAmount;

    @Column(nullable = false)
    private String transactionType;

    @OneToOne(mappedBy = "transaction")
    @JsonIgnoreProperties("transaction")
    private Orders order;

}
