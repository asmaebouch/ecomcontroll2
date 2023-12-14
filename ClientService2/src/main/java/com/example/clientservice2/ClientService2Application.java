package com.example.clientservice2;

import com.example.clientservice2.Dao.ClientDao;
import com.example.clientservice2.model.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientService2Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientService2Application.class, args);
	}

	@Bean
	CommandLineRunner start(ClientDao clientDao) {
		return args -> {

			clientDao.save(new Client(null, "asme", "asmae.boucheka@gmail.com"));
			clientDao.save(new Client(null, "asme2", "asmae1.boucheka@gmail.com"));
			clientDao.save(new Client(null, "asme3", "asmae2.boucheka@gmail.com"));

		};
	}
}
