package com.university.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.university.entities")
@EnableJpaRepositories(basePackages = "com.university.repositories")
@ComponentScan(basePackages = { "com.university.services", "com.university.controllers" })
public class UniversiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversiteApplication.class, args);
	}

}
