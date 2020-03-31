package com.learningSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImplementation service;

	
	@GetMapping(path = "/customers")
	public List<Customer> customerList() {
		return service.returnAllCustomers();
		
	}

}
