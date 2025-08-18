package com.example.Banking_app.service.impl;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.Banking_app.Dto.AccountDto;
import com.example.Banking_app.entity.Account;
import com.example.Banking_app.mapper.AccountMapper;
import com.example.Banking_app.repository.AccountRepository;
import com.example.Banking_app.service.AccountService;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto Deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        account.setBalance(account.getBalance() + amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }


    @Override
    public AccountDto Withdraw(Long id, Double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance for withdrawal");
        }
        account.setBalance(account.getBalance() - amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public List<AccountDto> GetAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return accounts.stream()
            .map(AccountMapper::mapToAccountDto)
            .collect(Collectors.toList());
    }    
            
    @Override
    public AccountDto DeleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        accountRepository.delete(account);
        return AccountMapper.mapToAccountDto(account);
    }






}


