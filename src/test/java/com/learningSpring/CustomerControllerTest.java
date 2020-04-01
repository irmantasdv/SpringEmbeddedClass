package com.learningSpring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class CustomerControllerTest {

	@Autowired
	CustomerService customerTestService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetCustomerListSuccess() throws URISyntaxException {
		RestTemplate resTemplate = new RestTemplate();
		ResponseEntity<String> result = resTemplate.getForEntity("http://localhost:8080/customers", String.class);
		assertEquals(200, result.getStatusCodeValue());
	}

}
