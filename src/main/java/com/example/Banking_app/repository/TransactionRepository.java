
package com.example.Banking_app.repository;

import com.example.Banking_app.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;      
import org.springframework.data.domain.Pageable;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findByAccountId(Long accountId, Pageable pageable); 
}
