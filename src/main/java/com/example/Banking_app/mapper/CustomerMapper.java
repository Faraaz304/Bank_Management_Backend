package com.example.Banking_app.mapper;

import com.example.Banking_app.dto.CustomerDto;
import com.example.Banking_app.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toDto(Customer entity) {
        if (entity == null) return null;
        return new CustomerDto(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getEmail(),
            entity.getPhone()
        );
    }

    public static Customer toEntity(CustomerDto dto) {
        if (dto == null) return null;
        return Customer.builder()
            .id(dto.id())
            .firstName(dto.firstName())
            .lastName(dto.lastName())
            .email(dto.email())
            .phone(dto.phone())
            .build();
    }
}

