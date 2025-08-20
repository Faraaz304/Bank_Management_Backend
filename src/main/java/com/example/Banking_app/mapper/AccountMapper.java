package com.example.Banking_app.mapper;

import com.example.Banking_app.dto.AccountDto;
import com.example.Banking_app.entity.Account;

public class AccountMapper {
    public static AccountDto toDto(Account entity) {
        if (entity == null) return null;
        return new AccountDto(
            entity.getId(),
            entity.getAccountNumber(),
            entity.getType(),
            entity.getBalance(),
            entity.getCustomer() != null ? entity.getCustomer().getId() : null
        );
    }

    public static Account toEntity(AccountDto dto) {
        if (dto == null) return null;
        return Account.builder()
            .id(dto.id())
            .accountNumber(dto.accountNumber())
            .type(dto.type())
            .balance(dto.balance())
            .build();
    }
}
