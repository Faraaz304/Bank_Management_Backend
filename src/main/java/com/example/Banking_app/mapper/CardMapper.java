package com.example.Banking_app.mapper;

import com.example.Banking_app.dto.CardDto;
import com.example.Banking_app.entity.Card;

public class CardMapper {
    public static CardDto toDto(Card entity) {
        if (entity == null) return null;
        return new CardDto(
            entity.getId(),
            entity.getCardNumber(),
            entity.getCardType(),
            entity.getExpiry(),
            entity.getStatus(),
            entity.getCustomer() != null ? entity.getCustomer().getId() : null,
            entity.getAccount() != null ? entity.getAccount().getId() : null
        );
    }

    public static Card toEntity(CardDto dto) {
        if (dto == null) return null;
        return Card.builder()
            .id(dto.id())
            .cardNumber(dto.cardNumber())
            .cardType(dto.cardType())
            .expiry(dto.expiry())
            .status(dto.status())
            .build();
    }
}
