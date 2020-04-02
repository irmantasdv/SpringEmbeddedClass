package com.learningSpring;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CustomerService {

	List<Customer> returnAllCustomers();

	ResponseEntity<Customer> getCustomer(Long id);

	ResponseEntity<?> deleteCustomer(Long id);

	ResponseEntity<Customer> createCustomer(Customer customer);

	ResponseEntity<Customer> updateCustomer(Long id, Customer customer);
}
