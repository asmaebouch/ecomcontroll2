package com.example.gestionticket3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.gestionticket3")
public class GestionTicket3Application {

	public static void main(String[] args) {
		SpringApplication.run(GestionTicket3Application.class, args);
	}

}
