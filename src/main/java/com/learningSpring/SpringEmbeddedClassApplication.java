package com.learningSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
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
	@Bean
	public Docket swaggerDocket() {

		return new Docket(DocumentationType.SWAGGER_2)

				.apiInfo(apiInfo()).select()

				.apis(RequestHandlerSelectors.basePackage("com.learningSpring"))

				.build();

	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("SpringEmbeddedClass").version("0.0.1-SNAPSHOT").build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringEmbeddedClassApplication.class, args);
	}

}
