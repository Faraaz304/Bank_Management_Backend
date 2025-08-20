
package com.example.Banking_app.dto;

public record AccountDto(
    Long id,
    String accountNumber,
    String type,
    double balance,
    Long customerId
) {}
