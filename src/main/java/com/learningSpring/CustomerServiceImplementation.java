package com.learningSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> returnAllCustomers() {

		return customerRepository.findAll();
	}

}
