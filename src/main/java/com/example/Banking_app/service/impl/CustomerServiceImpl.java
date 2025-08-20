package com.example.Banking_app.service.impl;

import com.example.Banking_app.dto.CustomerDto;
import com.example.Banking_app.entity.Customer;
import com.example.Banking_app.mapper.CustomerMapper;
import com.example.Banking_app.repository.CustomerRepository;
import com.example.Banking_app.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        Customer customer = CustomerMapper.toEntity(dto);
        return CustomerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return CustomerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto dto) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existing.setFirstName(dto.firstName());
        existing.setLastName(dto.lastName());
        existing.setEmail(dto.email());
        existing.setPhone(dto.phone());
        return CustomerMapper.toDto(customerRepository.save(existing));
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}
