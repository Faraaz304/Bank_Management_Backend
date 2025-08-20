package com.example.Banking_app.controller;

import com.example.Banking_app.dto.AccountDto;
import com.example.Banking_app.dto.TransactionDto;
import com.example.Banking_app.service.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<AccountDto> createAccountForCustomer(@PathVariable Long customerId, @RequestBody AccountDto dto) {
        return ResponseEntity.ok(accountService.createAccountForCustomer(customerId, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return ResponseEntity.ok(accountService.deposit(id, payload.get("amount")));
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return ResponseEntity.ok(accountService.withdraw(id, payload.get("amount")));
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<Page<TransactionDto>> getTransactions(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(accountService.getTransactions(id, pageable));
    }
}
