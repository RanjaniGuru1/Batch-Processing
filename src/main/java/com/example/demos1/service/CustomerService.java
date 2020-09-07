package com.example.demos1.service;

import java.util.List;
import java.util.Optional;

import com.example.demos1.model.Customer;

public interface CustomerService { 
	List<Customer> getAllCustomer();
	Optional<Customer> getCustomer(Long id);
}
