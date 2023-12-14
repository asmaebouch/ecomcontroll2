package com.example.clientservice;

import com.example.clientservice.Dao.ClientDao;
import com.example.clientservice.model.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(ClientDao clientDao){
        return args -> {
            clientDao.save(new Client(null,"asme","asmae.boucheka@gmail.com"));
            clientDao.save(new Client(null,"asme2","asmae1.boucheka@gmail.com"));
            clientDao.save(new Client(null,"asme3","asmae2.boucheka@gmail.com"));

        };
}

}
