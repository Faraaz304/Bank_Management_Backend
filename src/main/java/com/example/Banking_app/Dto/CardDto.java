package com.example.Banking_app.dto;

public record CardDto(
    Long id,
    String cardNumber,
    String cardType,
    String expiry,
    String status,
    Long customerId,
    Long accountId
) {}
