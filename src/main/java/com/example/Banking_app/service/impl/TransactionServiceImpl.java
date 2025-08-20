package com.example.Banking_app.service.impl;

import com.example.Banking_app.dto.TransactionDto;
import com.example.Banking_app.entity.Transaction;
import com.example.Banking_app.mapper.TransactionMapper;
import com.example.Banking_app.repository.TransactionRepository;
import com.example.Banking_app.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto getTransactionById(Long id) {
        Transaction tx = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return TransactionMapper.toDto(tx);
    }

    @Override
    public Page<TransactionDto> getTransactionsByAccount(Long accountId, Pageable pageable) {
        return transactionRepository.findByAccountId(accountId, pageable)
                .map(TransactionMapper::toDto);
    }
}
