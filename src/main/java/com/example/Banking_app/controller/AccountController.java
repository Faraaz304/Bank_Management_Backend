package com.example.Banking_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.example.Banking_app.Dto.AccountDto;
import com.example.Banking_app.service.AccountService;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

   @PostMapping
   public ResponseEntity<AccountDto> createAccount( @RequestBody AccountDto accountDto) {
             return new ResponseEntity<>(accountService.createAccount(accountDto) , HttpStatus.CREATED);
   }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PostMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
    Double amount = request.get("amount");
    AccountDto updatedAccount = accountService.Deposit(id, amount);
    return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }


    @PostMapping("/withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto updatedAccount = accountService.Withdraw(id, amount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.GetAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        AccountDto deletedAccount = accountService.DeleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully: " + deletedAccount.id());
    }

}
