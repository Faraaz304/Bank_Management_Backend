package com.example.Banking_app.dto;

public record TransactionDto(
    Long id,
    String type,
    double amount,
    String timestamp,
    double balanceAfter,
    Long accountId
) {}
