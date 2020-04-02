package com.learningSpring;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> returnAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public ResponseEntity<Customer> getCustomer(Long id) {

		return customerRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<?> deleteCustomer(Long id) {

		return customerRepository.findById(id).map(record -> {
			customerRepository.deleteById(id);
			return ResponseEntity.ok().body(record);
		}).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Customer> createCustomer(Customer customer) {

		customerRepository.save(customer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId())
				.toUri();
		return ResponseEntity.created(uri).body(customer);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Long id, Customer customer) {
		customerRepository.findById(id).map(record -> {
			record.setName(customer.getName());
			record.setContact(new CustomerContact(
					customer.getContact().getPhoneNr(),
					customer.getContact().getEmail(),
					customer.getContact().getAddress(),
					customer.getContact().getPostCode()));
			Customer updated = customerRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}) .orElse(ResponseEntity.notFound().build());
		return null;
	}

}
