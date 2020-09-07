package com.example.demos1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demos1.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findAll();
	public Optional<Customer> findById(Long id);
}
