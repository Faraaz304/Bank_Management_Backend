package com.example.Banking_app.service;

import com.example.Banking_app.dto.TransactionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    TransactionDto getTransactionById(Long id);
    Page<TransactionDto> getTransactionsByAccount(Long accountId, Pageable pageable);
}
