package com.example.Banking_app.mapper;

import com.example.Banking_app.Dto.AccountDto;
import com.example.Banking_app.entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()      
        );
    }
}
