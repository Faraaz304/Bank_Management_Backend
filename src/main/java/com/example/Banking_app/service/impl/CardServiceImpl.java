package com.example.Banking_app.service.impl;

import com.example.Banking_app.dto.CardDto;
import com.example.Banking_app.entity.Account;
import com.example.Banking_app.entity.Card;
import com.example.Banking_app.entity.Customer;
import com.example.Banking_app.mapper.CardMapper;
import com.example.Banking_app.repository.AccountRepository;
import com.example.Banking_app.repository.CardRepository;
import com.example.Banking_app.repository.CustomerRepository;
import com.example.Banking_app.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CardServiceImpl(CardRepository cardRepository, CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public CardDto issueCard(Long customerId, Long accountId, CardDto dto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Account account = null;
        if (accountId != null) {
            account = accountRepository.findById(accountId)
                    .orElseThrow(() -> new RuntimeException("Account not found"));
        }

        Card card = CardMapper.toEntity(dto);
        card.setCustomer(customer);
        card.setAccount(account);
        card.setCardNumber(UUID.randomUUID().toString().replace("-", "").substring(0, 16)); // simple card number
        card.setStatus("ACTIVE");
        return CardMapper.toDto(cardRepository.save(card));
    }

    @Override
    public CardDto getCardById(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        return CardMapper.toDto(card);
    }

    @Override
    public List<CardDto> getCardsByCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"))
                .getCards()
                .stream()
                .map(CardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto updateCardStatus(Long id, String status) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        card.setStatus(status);
        return CardMapper.toDto(cardRepository.save(card));
    }

    @Override
    public void deleteCard(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new RuntimeException("Card not found");
        }
        cardRepository.deleteById(id);
    }
}
