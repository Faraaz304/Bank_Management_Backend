package com.example.Banking_app.entity;

import lombok.*;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Transactions")
public class Transaction {
    // Define fields for Transaction entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private Double amount; // Amount of the transaction
    private String type; // Type of transaction (e.g., "DEPOSIT", "WITHDRAWAL" or "TRANSFER")
    private OffsetDateTime timestamp; // Timestamp of the transaction
    private Double balanceAfter; // Balance after the transaction

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account; // Reference to the account associated with the transaction

    // Constructors, getters, setters, etc. can be added as needed
}
