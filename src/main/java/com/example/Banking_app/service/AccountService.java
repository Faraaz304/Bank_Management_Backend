// package com.example.Banking_app.service;

// import java.util.List;

// import com.example.Banking_app.dto.AccountDto;

// public interface AccountService {
//     AccountDto createAccount(AccountDto accountDto);
//     AccountDto getAccountById(Long id);
//     AccountDto Deposit(Long id , Double amount); // Added method to retrieve account by ID
//     AccountDto Withdraw(Long id, Double amount); // Added method to withdraw amount from account
//     List<AccountDto> GetAllAccounts(); // Added method to retrieve all accounts
//     AccountDto DeleteAccount(Long id); // Added method to retrieve account by ID
// }


package com.example.Banking_app.service;

import com.example.Banking_app.dto.AccountDto;
import com.example.Banking_app.dto.TransactionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    AccountDto createAccountForCustomer(Long customerId, AccountDto dto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long accountId, double amount);
    AccountDto withdraw(Long accountId, double amount);
    Page<TransactionDto> getTransactions(Long accountId, Pageable pageable);
}
