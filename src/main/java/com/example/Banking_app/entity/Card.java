package com.example.Banking_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Cards")
public class Card {
    // Define fields for Card entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber; // Card number
    private String cardType; // debit or credit
    private String expiry; // Expiry date of the card
    private String status; // expired or active or blocked
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer; // Reference to the customer who owns the card

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id" , nullable = true) 
    private Account account; // Reference to the account associated with the card

    // Constructors, getters, setters, etc. can be added as needed
}
