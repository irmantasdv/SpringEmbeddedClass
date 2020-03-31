package com.learningSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEmbeddedClassApplication {

	@Autowired
	CustomerRepository repo;

	@Bean
	public CommandLineRunner demoData() {
		return (args) -> {
			repo.save(new Customer("No Name", new CustomerContact(1230, "asda@kitas.com", "Mary Jane 65", 345350)));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringEmbeddedClassApplication.class, args);
	}

}
