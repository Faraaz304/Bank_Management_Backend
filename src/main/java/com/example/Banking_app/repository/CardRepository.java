
package com.example.Banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Banking_app.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    // Custom queries here
}