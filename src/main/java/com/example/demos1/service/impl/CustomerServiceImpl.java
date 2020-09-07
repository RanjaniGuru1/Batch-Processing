package com.example.demos1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demos1.exception.CustomerNotFoundException;
import com.example.demos1.exception.NoDataFoundException;
import com.example.demos1.model.Customer;
import com.example.demos1.repository.CustomerRepository;
import com.example.demos1.service.CustomerService;
import static java.util.Objects.isNull;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerLists = customerRepository.findAll();
		
		if (customerLists.isEmpty()) {
			throw new NoDataFoundException();
		}
		
		return customerLists;
	}
	
	@Override
	public Optional<Customer> getCustomer(Long id) {
//		return customerRepository.findById(id)
//                .orElseThrow(() -> new CustomerNotFoundException(id));
		Optional<Customer> customerDet = customerRepository.findById(id);
//						
		if (customerDet.isPresent()) {
			//throw new CustomerNotFoundException(id);
			//System.out.println("null check");
			return customerDet;
		} else {
			throw new CustomerNotFoundException(id);
			//System.out.println("not null check");
		}
//		return Optional.ofNullable(customerRepository.findById(id))
//                .orElseThrow(() -> new CustomerNotFoundException(id));
		//return customerDet;
	}
}
