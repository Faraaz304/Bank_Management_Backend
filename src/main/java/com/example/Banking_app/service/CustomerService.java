package com.example.Banking_app.service;

import com.example.Banking_app.dto.CustomerDto;
import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto dto);
    CustomerDto getCustomerById(Long id);
    List<CustomerDto> getAllCustomers();
    CustomerDto updateCustomer(Long id, CustomerDto dto);
    void deleteCustomer(Long id);
}
