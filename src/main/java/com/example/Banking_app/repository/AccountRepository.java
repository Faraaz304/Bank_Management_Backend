package com.example.Banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
