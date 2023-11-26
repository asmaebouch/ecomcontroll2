package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepositor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
@Bean
	CommandLineRunner strat(CustomerRepositor customerRepositor){
		return args -> {
customerRepositor.save(new Customer(null,"imane","imae@gmail.com"));
			customerRepositor.save(new Customer(null,"imane2","imae@gmail.com"));
			customerRepositor.save(new Customer(null,"imane2","imae@gmail.com"));



		};
}
}
