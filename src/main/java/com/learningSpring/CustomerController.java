package com.learningSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api
@RestController
public class CustomerController {

	@Autowired
	CustomerServiceImplementation service;

	@GetMapping(path = "/customers")
	public List<Customer> customerList() {
		return service.returnAllCustomers();

	}

	@GetMapping(value = "/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {

		return service.getCustomer(id);
	}

	@DeleteMapping(path = "/customers/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
		return service.deleteCustomer(id);
	}

	@PostMapping(path = "/")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		return service.createCustomer(customer);
	}

	@PutMapping(path = "/customers/{id}")
	public ResponseEntity<Customer> updateClient(@PathVariable Long id, @RequestBody Customer customer) {
		return service.updateCustomer(id, customer);

	}
}
