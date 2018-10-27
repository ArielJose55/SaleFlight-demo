package com.learning.saleflight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.learnig.saleflight.repositories")
@EntityScan("com.learnig.saleflight.entities")
@SpringBootApplication
public class SaleFlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleFlightApplication.class, args);
	}
}
