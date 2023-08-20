package com.arman.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation description",
				version = "v1.0",
				contact = @Contact(
						name = "Arman",
						email = "arman@gmail.com",
						url = "http://www.localhost:1010"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.localhost:1010/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management System Documentation",
				url = "http://www.localhost:1010/user_management.html"
		)
)
public class SpringbootRestfulWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
