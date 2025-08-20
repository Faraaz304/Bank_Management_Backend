package com.example.Banking_app.service;

import com.example.Banking_app.dto.CardDto;
import java.util.List;

public interface CardService {
    CardDto issueCard(Long customerId, Long accountId, CardDto dto);
    CardDto getCardById(Long id);
    List<CardDto> getCardsByCustomer(Long customerId);
    CardDto updateCardStatus(Long id, String status);
    void deleteCard(Long id);
}
