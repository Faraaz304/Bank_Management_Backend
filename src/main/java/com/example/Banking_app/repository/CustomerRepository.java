
package com.example.Banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Banking_app.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom queries here
}
