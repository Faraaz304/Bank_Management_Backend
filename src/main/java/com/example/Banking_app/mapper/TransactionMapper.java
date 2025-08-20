package com.example.Banking_app.mapper;

import com.example.Banking_app.dto.TransactionDto;
import com.example.Banking_app.entity.Transaction;

import java.time.format.DateTimeFormatter;

public class TransactionMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static TransactionDto toDto(Transaction entity) {
        if (entity == null) return null;
        return new TransactionDto(
            entity.getId(),
            entity.getType(),
            entity.getAmount(),
            entity.getTimestamp() != null ? entity.getTimestamp().format(formatter) : null,
            entity.getBalanceAfter(),
            entity.getAccount() != null ? entity.getAccount().getId() : null
        );
    }

    public static Transaction toEntity(TransactionDto dto) {
        if (dto == null) return null;
        return Transaction.builder()
            .id(dto.id())
            .type(dto.type())
            .amount(dto.amount())
            // timestamp usually set in service, not from dto
            .balanceAfter(dto.balanceAfter())
            .build();
    }
}
