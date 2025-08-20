package com.example.Banking_app.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Customers")

public class Customer {
    // Define fields for Customer entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the customer
    private String firstName; // Name of the customer
    private String lastName; // Last name of the customer
    @Column(unique = true)
    private String email; // Email address of the customer
    private String phone; // Phone number of the customer

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> Accounts; // List of accounts associated with the customer
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> Cards; // List of cards associated with the customer
    
}
