package com.example.Banking_app.service;

import com.example.Banking_app.Dto.AccountDto;


import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto Deposit(Long id , Double amount); // Added method to retrieve account by ID
    AccountDto Withdraw(Long id, Double amount); // Added method to withdraw amount from account
    List<AccountDto> GetAllAccounts(); // Added method to retrieve all accounts
    AccountDto DeleteAccount(Long id); // Added method to retrieve account by ID
}
