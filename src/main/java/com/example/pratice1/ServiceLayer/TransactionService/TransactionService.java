package com.example.pratice1.ServiceLayer.TransactionService;

import com.example.pratice1.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements TransactionImpl{

    @Autowired
    private TransactionRepo transactionRepo;
}
