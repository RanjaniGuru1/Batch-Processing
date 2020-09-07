package com.example.demos1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demos1.model.Customer;
import com.example.demos1.service.CustomerService;

/**
 * This is a customer controller
 * @author DELL
 *
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping(value="{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}
}
