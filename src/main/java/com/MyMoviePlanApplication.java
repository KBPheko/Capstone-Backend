package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
public class MyMoviePlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMoviePlanApplication.class, args);
		System.out.println("Server has started on port number 8080");
	}

}
