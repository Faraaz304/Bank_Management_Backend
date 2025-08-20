package com.example.Banking_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountNumber(String accountNumber); // Method to find an account by its ID
}
