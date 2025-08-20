package com.example.Banking_app.service.impl;

import com.example.Banking_app.dto.AccountDto;
import com.example.Banking_app.dto.TransactionDto;
import com.example.Banking_app.entity.Account;
import com.example.Banking_app.entity.Customer;
import com.example.Banking_app.entity.Transaction;
import com.example.Banking_app.mapper.AccountMapper;
import com.example.Banking_app.mapper.TransactionMapper;
import com.example.Banking_app.repository.AccountRepository;
import com.example.Banking_app.repository.CustomerRepository;
import com.example.Banking_app.repository.TransactionRepository;
import com.example.Banking_app.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository,
                              TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDto createAccountForCustomer(Long customerId, AccountDto dto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Account account = AccountMapper.toEntity(dto);
        account.setCustomer(customer);
        account.setAccountNumber(UUID.randomUUID().toString()); // generate unique number
        return AccountMapper.toDto(accountRepository.save(account));
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.toDto(account);
    }

    @Override
    @Transactional
    public AccountDto deposit(Long accountId, double amount) {
        if (amount <= 0) throw new RuntimeException("Amount must be positive");
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);

        Transaction tx = Transaction.builder()
                .type("DEPOSIT")
                .amount(amount)
                .timestamp(OffsetDateTime.now())
                .balanceAfter(account.getBalance())
                .account(account)
                .build();
        transactionRepository.save(tx);
        accountRepository.save(account);

        return AccountMapper.toDto(account);
    }

    @Override
    @Transactional
    public AccountDto withdraw(Long accountId, double amount) {
        if (amount <= 0) throw new RuntimeException("Amount must be positive");
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) throw new RuntimeException("Insufficient funds");

        account.setBalance(account.getBalance() - amount);

        Transaction tx = Transaction.builder()
                .type("WITHDRAWAL")
                .amount(amount)
                .timestamp(OffsetDateTime.now())
                .balanceAfter(account.getBalance())
                .account(account)
                .build();
        transactionRepository.save(tx);
        accountRepository.save(account);

        return AccountMapper.toDto(account);
    }

    @Override
    public Page<TransactionDto> getTransactions(Long accountId, Pageable pageable) {
        return transactionRepository.findByAccountId(accountId, pageable)
                .map(TransactionMapper::toDto);
    }
}
