package com.example.Banking_app.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Accounts")
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String accountNumber; // Unique account number
    private String type; // Type of account (e.g., "SAVINGS", "CHECKING")
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer; // Reference to the customer who owns the account

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions; // List of transactions associated with the account
}
